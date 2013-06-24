package com.myinstitution.myapp.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myinstitution.myapp.crypto.Decrypt;
import com.myinstitution.myapp.crypto.Encrypt;
import com.myinstitution.myapp.logger.LoggerFactory;

@Controller
@RequestMapping("/crypto.do")
public class CryptoController extends AbstractController {

    private static Logger logger = LoggerFactory
            .getLogger(CryptoController.class);

    @RequestMapping(params = "action=prepareCryptoHome")
    public ModelAndView prepareCryptoHome() {
        logger.info("Entering");
        try {
            processEncryption();
            processDecryption();
        } catch (IOException e) {
            logger.error("Error while crypto", e);
        }
        ModelAndView modelAndView = new ModelAndView("cryptoHome");
        logger.info("Exiting");
        return modelAndView;
    }

    private static final String HOME_TEMP = "C:\\Storehouse\\tmp\\second";
    private static final String PLAIN_FOLDER_INPUT = HOME_TEMP
            + "\\com\\myinstitution\\myapp\\input\\plainfiles\\";
    private static final String ENCRYPTED_FOLDER_INPUT = HOME_TEMP
            + "\\com\\myinstitution\\myapp\\input\\encryptedfiles\\";
    private static final String ENCRYPTED_FOLDER_OUTPUT = HOME_TEMP
            + "\\com\\myinstitution\\myapp\\output\\encryptedfiles\\";
    private static final String DECRYPTED_FOLDER_OUTPUT = HOME_TEMP
            + "\\com\\myinstitution\\myapp\\output\\decryptedfiles\\";

    private static void processEncryption() throws IOException {
        logger.debug("Entering");
        logger.debug("Starting Encryption of all files.");
        File file = new File(PLAIN_FOLDER_INPUT);
        String[] files = file.list();
        for (int i = 0; i < files.length; i++) {
            String inputFilepath = PLAIN_FOLDER_INPUT + files[i];
            logger.debug("Starting Encryption of file: '" + inputFilepath + "'");
            String outputfilePath = ENCRYPTED_FOLDER_OUTPUT + files[i];
            getEncrypt().encrypt(inputFilepath, outputfilePath);
            logger.info("Completed Encryption of file: '" + inputFilepath + "'");
        }
        logger.info("Completed Encryption of all files.");
        logger.debug("Exiting");
    }

    private static void processDecryption() throws IOException {
        logger.debug("Entering");
        logger.debug("Starting Decryption of all files.");
        File file = new File(ENCRYPTED_FOLDER_INPUT);
        String[] files = file.list();
        for (int i = 0; i < files.length; i++) {
            String inputFilepath = ENCRYPTED_FOLDER_INPUT + files[i];
            logger.debug("Starting Decryption of file: '" + inputFilepath + "'");
            String outputfilePath = DECRYPTED_FOLDER_OUTPUT + files[i];
            getDecrypt().decrypt(inputFilepath, outputfilePath);
            logger.info("Completed Decryption of file: '" + inputFilepath + "'");
        }
        logger.info("Completed Decryption of all files.");
        logger.debug("Exiting");
    }

    private static Encrypt getEncrypt() {
        logger.info("Entering");
        Encrypt encryptBean = (Encrypt) getBeanFactory().getBean("EncryptBean");
        logger.info("Exiting");
        return encryptBean;
    }

    private static Decrypt getDecrypt() {
        logger.info("Entering");
        Decrypt decryptBean = (Decrypt) getBeanFactory().getBean("DecryptBean");
        logger.info("Exiting");
        return decryptBean;
    }

}

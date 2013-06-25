package com.myinstitution.myapp.crypto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;

import com.myinstitution.myapp.logger.LoggerFactory;

public class EncryptDefaultImpl implements Encrypt {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(EncryptDefaultImpl.class);

    private void encrypt(FileInputStream fileInputStream,
            FileOutputStream fileOutputStream) throws IOException {
        LOGGER.debug("Entering.");
        int read = fileInputStream.read();
        while (read != -1) {
            fileOutputStream.write(read + 1);
            read = fileInputStream.read();
        }
        LOGGER.info("Successfully Completed Encryption.");
        LOGGER.debug("Exiting.");
    }

    @Override
    public void encrypt(String inputFilepath, String outputfilePath)
            throws FileNotFoundException, IOException {
        LOGGER.debug("Entering.");
        FileInputStream fileInputStream = new FileInputStream(inputFilepath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputfilePath);
        EncryptDefaultImpl encrypt = new EncryptDefaultImpl();
        encrypt.encrypt(fileInputStream, fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        LOGGER.debug("Exiting.");
    }
}

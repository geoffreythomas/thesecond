package com.myinstitution.myapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;

import com.myinstitution.myapp.logger.LoggerFactory;

public class Decrypt {
    private static final Logger LOGGER = LoggerFactory.getLogger(Decrypt.class);

    private void decrypt(FileInputStream fileInputStream,
            FileOutputStream fileOutputStream) throws IOException {
        LOGGER.debug("Entering.");
        int read = fileInputStream.read();
        while (read != -1) {
            fileOutputStream.write(read - 1);
            read = fileInputStream.read();
        }
        LOGGER.info("Successfully Completed Decryption.");
        LOGGER.debug("Exiting.");
    }

    public void decrypt(String inputFilepath, String outputfilePath)
            throws IOException {
        LOGGER.debug("Entering.");
        FileInputStream fileInputStream = new FileInputStream(inputFilepath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputfilePath);
        Decrypt decrypt = new Decrypt();
        decrypt.decrypt(fileInputStream, fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        LOGGER.debug("Exiting.");
    }
}

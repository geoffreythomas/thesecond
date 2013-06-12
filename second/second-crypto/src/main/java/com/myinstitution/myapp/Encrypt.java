package com.myinstitution.myapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.slf4j.Logger;

import com.myinstitution.myapp.logger.LoggerFactory;

public class Encrypt {
    private static final Logger LOGGER = LoggerFactory.getLogger(Encrypt.class);

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

    public void encrypt(String inputFilepath, String outputfilePath)
            throws FileNotFoundException, IOException {
        LOGGER.debug("Entering.");
        FileInputStream fileInputStream = new FileInputStream(inputFilepath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputfilePath);
        Encrypt encrypt = new Encrypt();
        encrypt.encrypt(fileInputStream, fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        LOGGER.debug("Exiting.");
    }
}

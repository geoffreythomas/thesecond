package com.myinstitution.myapp.crypto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.crypto.SecretKey;

import org.slf4j.Logger;

import com.myinstitution.myapp.logger.LoggerFactory;

public class DecryptDefaultImpl implements Decrypt {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DecryptDefaultImpl.class);

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

    @Override
    public void decrypt(String inputFilepath, String outputfilePath,
			SecretKey key)
            throws IOException {
        LOGGER.debug("Entering.");
        FileInputStream fileInputStream = new FileInputStream(inputFilepath);
        FileOutputStream fileOutputStream = new FileOutputStream(outputfilePath);
        DecryptDefaultImpl decrypt = new DecryptDefaultImpl();
        decrypt.decrypt(fileInputStream, fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        LOGGER.debug("Exiting.");
	}
}

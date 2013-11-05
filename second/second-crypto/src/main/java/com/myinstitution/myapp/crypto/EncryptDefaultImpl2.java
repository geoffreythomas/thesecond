package com.myinstitution.myapp.crypto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import org.slf4j.Logger;

import com.myinstitution.myapp.common.FilePersistence;
import com.myinstitution.myapp.crypto.Encrypt;
import com.myinstitution.myapp.logger.LoggerFactory;

public class EncryptDefaultImpl2 implements Encrypt {
	// TODO Complete the development
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EncryptDefaultImpl2.class);

	public void encrypt(String inputFilepath, String outputfilePath,
			SecretKey key) throws FileNotFoundException, IOException {
		LOGGER.debug("Entering.");
		try {
			Serializable serializable = (Serializable) FilePersistence
					.readToByteArray(inputFilepath);
			SealedObject sealedObject = Crypto2.encrypt(serializable, key);
			LOGGER.debug("Sealed Object: " + sealedObject.toString());
			LOGGER.info("Successfully Completed Encryption.");
			FilePersistence.write(sealedObject, outputfilePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.debug("Exiting.");
	}
}

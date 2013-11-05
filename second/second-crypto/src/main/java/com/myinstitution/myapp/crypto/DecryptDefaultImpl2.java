package com.myinstitution.myapp.crypto;

import java.io.IOException;
import java.io.Serializable;

import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import org.slf4j.Logger;

import com.myinstitution.myapp.common.FilePersistence;
import com.myinstitution.myapp.crypto.Decrypt;
import com.myinstitution.myapp.logger.LoggerFactory;

public class DecryptDefaultImpl2 implements Decrypt {
	// TODO Complete the development
	private static final Logger LOGGER = LoggerFactory
			.getLogger(DecryptDefaultImpl2.class);

	public void decrypt(String inputFilepath, String outputfilePath,
			SecretKey key) throws IOException {
		LOGGER.debug("Entering.");
		try {
			SealedObject sealedObject = (SealedObject) FilePersistence
					.read(inputFilepath);
			Serializable decrypt = (Serializable) Crypto2.decrypt(sealedObject,
					key);
			FilePersistence
					.writeFromByteArray((Object) decrypt, outputfilePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.debug("Exiting.");
	}
}

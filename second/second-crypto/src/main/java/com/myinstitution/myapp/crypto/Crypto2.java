package com.myinstitution.myapp.crypto;

import java.io.Serializable;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import org.slf4j.Logger;

import com.myinstitution.myapp.common.MessageKeys;
import com.myinstitution.myapp.logger.LoggerFactory;

public class Crypto2 {

	private static Logger LOGGER = LoggerFactory.getLogger(Crypto2.class);

	public static SealedObject encrypt(Serializable inputValue, SecretKey key)
			throws Exception {
		SecurityProvider2.configureDefaultSecurityProvider();
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding",
					SecurityProvider2.getDefaultSecurityProvider().getName());
			cipher.init(Cipher.ENCRYPT_MODE, key);
		} catch (Exception e) {
			throwException("Error during creation of cipher: ", e);
		}

		SealedObject sealedObject = null;
		try {
			sealedObject = new SealedObject(inputValue, cipher);
		} catch (Exception e) {
			throwException("Error during encryption: ", e);
		}
		return sealedObject;
	}

	public static Object decrypt(SealedObject sealedObject, SecretKey key)
			throws Exception {
		SecurityProvider2.configureDefaultSecurityProvider();
		Object object = null;
		try {
			object = sealedObject.getObject(key, SecurityProvider2
					.getDefaultSecurityProvider().getName());
		} catch (Exception e) {
			throwException("Error during decryption: ", e);
		}
		return object;
	}

	private static void throwException(String messgeKey, Exception cause,
			String... params) throws Exception {
		LOGGER.error(messgeKey + params, cause);
		LOGGER.error(MessageKeys.ERROR_GENERIC,
				"exception cause:" + cause.getMessage());
		throw cause;
	}
}

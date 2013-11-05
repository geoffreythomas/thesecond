package com.myinstitution.myapp.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.slf4j.Logger;

import com.myinstitution.myapp.common.MessageKeys;
import com.myinstitution.myapp.logger.LoggerFactory;

public class KeyGenerator2 {
	private static Logger LOGGER = LoggerFactory.getLogger(KeyGenerator2.class);

	public static SecretKey createKey() throws Exception {
		KeyGenerator keyGenerator = null;
		try {
			keyGenerator = KeyGenerator.getInstance("AES", SecurityProvider2
					.getDefaultSecurityProvider().getName());
		} catch (Exception e) {
			throwException("Error generating key: ", e);
		}
		keyGenerator.init(256);
		final SecretKey key = keyGenerator.generateKey();
		return key;
	}

	private static void throwException(String messgeKey, Exception cause,
			String... params) throws Exception {
		LOGGER.error(messgeKey + params, cause);
		LOGGER.error(MessageKeys.ERROR_GENERIC,
				"exception cause:" + cause.getMessage());
		throw cause;
	}
}

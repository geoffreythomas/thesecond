package com.myinstitution.myapp.crypto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.crypto.SecretKey;

import org.slf4j.Logger;

import com.myinstitution.myapp.common.MessageKeys;
import com.myinstitution.myapp.esafe.ESafe;
import com.myinstitution.myapp.esafe.ESafeImpl;
import com.myinstitution.myapp.logger.LoggerFactory;

public class KeyStore2 {
	public static final String ESAFE_PATH = "C:\\Storehouse\\tmp\\CoreCrypto\\test_esafe2.esafe";
	private static Logger LOGGER = LoggerFactory.getLogger(KeyStore2.class);

	public static void saveKey(final SecretKey key, final String keyKey)
			throws Exception {
		try {
			final ByteArrayOutputStream bStream = new ByteArrayOutputStream();
			final ObjectOutputStream oStream = new ObjectOutputStream(bStream);
			oStream.writeObject(key);
			final byte[] b = bStream.toByteArray();
			final ESafe baseESafe = getBaseESafe();
			if (baseESafe.containsItem(keyKey)) {
				// baseESafe.removeItem(keyKey);
				throw new Exception("A Key already exists with the keyKey: "
						+ keyKey);
			}
			baseESafe.createItem(keyKey, b);
		} catch (Exception e) {
			throwException("Error storing key in esafe: ", e);
		}
	}

	public static SecretKey getKey(final String keyKey) throws Exception {
		SecretKey key = null;
		try {
			final byte[] b = getBaseESafe().retrieveItemAsBinary(keyKey);
			final ByteArrayInputStream bStream = new ByteArrayInputStream(b);
			final ObjectInputStream oStream = new ObjectInputStream(bStream);
			key = (SecretKey) oStream.readObject();
		} catch (Exception e) {
			throwException("Error getting key from esafe: ", e);
		}

		return key;
	}

	private static ESafe getBaseESafe() throws Exception {
		ESafe eSafe = null;
		try {
			eSafe = new ESafeImpl(ESAFE_PATH);
		} catch (Exception exception) {
			throwException(MessageKeys.ERROR_INCORRECT_ESAFE_CREDENTIALS,
					exception);
		}
		return eSafe;
	}

	private static void throwException(String messgeKey, Exception cause,
			String... params) throws Exception {
		LOGGER.error(messgeKey + params, cause);
		LOGGER.error(MessageKeys.ERROR_GENERIC,
				"exception cause:" + cause.getMessage());
		throw cause;
	}
}

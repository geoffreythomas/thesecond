package com.myinstitution.myapp.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;

import com.myinstitution.myapp.logger.LoggerFactory;

public class FilePersistence {
	private static Logger LOGGER = LoggerFactory
			.getLogger(FilePersistence.class);

	public static void write(Object object, String path) throws Exception {
		try {
			final ObjectOutputStream objectOutputStream = new ObjectOutputStream(
					new FileOutputStream(new File(path)));
			objectOutputStream.writeObject(object);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			LOGGER.error(MessageKeys.ERROR_WRITING_FILE + path);
			throw new Exception(e);
		} catch (IOException e) {
			LOGGER.error(MessageKeys.ERROR_WRITING_FILE + path);
			throw new Exception(e);
		}
	}

	public static Object read(String path) throws Exception {
		try {
			final FileInputStream inputstream = new FileInputStream(new File(
					path));
			final ObjectInputStream objectInputStream = new ObjectInputStream(
					inputstream);
			return (Object) objectInputStream.readObject();
		} catch (FileNotFoundException e) {
			LOGGER.error(MessageKeys.ERROR_READING_FILE + path);
			throw new Exception(e);
		} catch (IOException e) {
			LOGGER.error(MessageKeys.ERROR_READING_FILE + path);
			throw new Exception(e);
		} catch (ClassNotFoundException e) {
			LOGGER.error(MessageKeys.ERROR_READING_FILE + path);
			throw new Exception(e);
		}
	}

	public static void writeFromByteArray(Object object, String path)
			throws Exception {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File(
					path));
			IOUtils.write((byte[]) object, fileOutputStream);
		} catch (FileNotFoundException e) {
			LOGGER.error(MessageKeys.ERROR_WRITING_FILE + path);
			throw new Exception(e);
		} catch (IOException e) {
			LOGGER.error(MessageKeys.ERROR_WRITING_FILE + path);
			throw new Exception(e);
		}
	}

	public static Object readToByteArray(String path) throws Exception {
		try {
			final FileInputStream inputstream = new FileInputStream(new File(
					path));
			return (Object) IOUtils.toByteArray(inputstream);
		} catch (FileNotFoundException e) {
			LOGGER.error(MessageKeys.ERROR_READING_FILE + path);
			throw new Exception(e);
		} catch (IOException e) {
			LOGGER.error(MessageKeys.ERROR_READING_FILE + path);
			throw new Exception(e);
		}
	}
}

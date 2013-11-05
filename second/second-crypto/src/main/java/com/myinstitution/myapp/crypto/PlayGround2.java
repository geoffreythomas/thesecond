package com.myinstitution.myapp.crypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Timestamp;
import java.util.GregorianCalendar;
import java.util.Scanner;

import javax.crypto.SecretKey;

import org.slf4j.Logger;

import com.myinstitution.myapp.logger.LoggerFactory;

/**
 * @author Geoffrey Thomas
 * 
 */
public class PlayGround2 {
	private static SecretKey currentKey = null;
	private static final String BASE_DATA_KEY = "BASE_DATA_KEY";
    private static final String HOME_TEMP = "C:\\Storehouse\\tmp\\second";
    private static final String DEFAULT_FILENAME = "passwords.data";
    private static final String PLAIN_FOLDER_INPUT = HOME_TEMP
            + "\\com\\myinstitution\\myapp\\input\\plainfiles\\";
    private static final String ENCRYPTED_FOLDER_INPUT = HOME_TEMP
            + "\\com\\myinstitution\\myapp\\input\\encryptedfiles\\";
    private static final String ENCRYPTED_FOLDER_OUTPUT = HOME_TEMP
            + "\\com\\myinstitution\\myapp\\output\\encryptedfiles\\";
    private static final String DECRYPTED_FOLDER_OUTPUT = HOME_TEMP
            + "\\com\\myinstitution\\myapp\\output\\decryptedfiles\\";

    public static final String PLAIN_FILE_INPUT = PLAIN_FOLDER_INPUT
            + DEFAULT_FILENAME;
    private static final String ENCRYPTED_FILE_INPUT = ENCRYPTED_FOLDER_INPUT
            + DEFAULT_FILENAME;
    private static final String ENCRYPTED_FILE_OUTPUT = ENCRYPTED_FOLDER_OUTPUT
            + DEFAULT_FILENAME;
    private static final String DECRYPTED_FILE_OUTPUT = DECRYPTED_FOLDER_OUTPUT
            + DEFAULT_FILENAME;

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayGround2.class);
    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        // BasicConfigurator.configure();
        LOGGER.debug("Welcome to Encryption.");
        System.out.println("Welcome to Encryption.");
        process();
        LOGGER.debug("Exiting main.");
    }

    private static void process() throws Exception {
        LOGGER.debug("Entering process.");
        displayOptions();
        processUserInput();
        LOGGER.debug("Exiting process.");
    }

    private static void displayOptions() {
        LOGGER.debug("Entering displayOptions.");
        System.out.println("Enter your choice:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.println("3. Generate Key");
        System.out.println("4. Use Default Key");
        System.out.println("5. List Keys(Not implemented)");
        System.out.println("9. Exit");
        LOGGER.debug("Exiting displayOptions.");
    }

    private static void processUserInput() throws Exception {
        LOGGER.debug("Entering processUserInput.");
        scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String choice = nextLine.trim();
            if (choice.equals("1")) {
                LOGGER.debug("Starting Encryption.");
                System.out.println("Starting Encryption.");
                encrypt();
                System.out.println("Completed Encryption.");
                displayOptions();
            } else if (choice.equals("2")) {
                LOGGER.debug("Starting Decryption.");
                System.out.println("Starting Decryption.");
                decrypt();
                System.out.println("Completed Decryption.");
                displayOptions();
            } else if (choice.equals("3")) {
                LOGGER.debug("Starting Key Generation.");
                System.out.println("Starting Key Generation.");
                generateKey();
                System.out.println("Completed Key Generation.");
                displayOptions();
            }  else if (choice.equals("4")) {
                LOGGER.debug("Starting to use default key.");
                System.out.println("Starting to use default key.");
                useDefaultKey();
                System.out.println("Completed to use default key.");
                displayOptions();
            } else if (choice.equals("9")) {
                LOGGER.debug("Exiting.");
                System.out.println("Exiting.");
                System.exit(0);
            } else {
                LOGGER.error("Invalid choice entered.");
                // System.out.print("\033[H\033[2J");
                System.out.println("You have entered an invalid choice.");
                displayOptions();
            }
        }
        scanner.close();
        LOGGER.debug("Exiting processUserInput.");
    }

    private static void encrypt() throws FileNotFoundException, IOException {
        LOGGER.debug("Entering encrypt.");
        displayEncryptOptions();
        processUserInputForEncryption();
        LOGGER.debug("Exiting encrypt.");
    }

    private static void displayEncryptOptions() {
        LOGGER.debug("Entering displayEncryptOptions.");
        System.out.println("Encrypt all the files in the folder '"
                + PLAIN_FOLDER_INPUT + "' ?");
        System.out.println("1. Yes");
        System.out.println("2. No - Encrypt only the default file");
        System.out.println("9. Exit");
        LOGGER.debug("Exiting displayEncryptOptions.");
    }

    private static void processUserInputForEncryption() throws IOException {
        LOGGER.debug("Entering processUserInputForEncryption.");
        scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String choice = nextLine.trim();
            if (choice.equals("1")) {
                LOGGER.debug("Starting Encryption of all files.");
                System.out.println("Starting Encryption of all files.");
                File file = new File(PLAIN_FOLDER_INPUT);
                String[] files = file.list();
                for (int i = 0; i < files.length; i++) {
                    String inputFilepath = PLAIN_FOLDER_INPUT + files[i];
                    LOGGER.debug("Starting Encryption of file: '"
                            + inputFilepath + "'");
                    System.out.println("Starting Encryption of file: '"
                            + inputFilepath + "'");
                    String outputfilePath = ENCRYPTED_FOLDER_OUTPUT + files[i];
                    getEncrypt().encrypt(inputFilepath, outputfilePath, currentKey);
                    System.out.println("Completed Encryption of file: '"
                            + inputFilepath + "'");
                }
                System.out.println("Completed Encryption of all files.");
                displayEncryptOptions();
            } else if (choice.equals("2")) {
                String inputFilepath = PLAIN_FILE_INPUT;
                LOGGER.debug("Starting Encryption of file: '" + inputFilepath
                        + "'");
                System.out.println("Starting Encryption of file: '"
                        + inputFilepath + "'");
                String outputfilePath = ENCRYPTED_FILE_OUTPUT;
                getEncrypt().encrypt(inputFilepath, outputfilePath, currentKey);
                System.out.println("Completed Encryption of file: '"
                        + inputFilepath + "'");
                displayEncryptOptions();
            } else if (choice.equals("9")) {
                LOGGER.debug("Exiting.");
                System.out.println("Exiting.");
                break;
            } else {
                LOGGER.error("Invalid choice entered.");
                // System.out.print("\033[H\033[2J");
                System.out.println("You have entered an invalid choice.");
                displayEncryptOptions();
            }
        }
        // scanner.close();
        LOGGER.debug("Exiting processUserInputForEncryption.");
    }

    private static Encrypt getEncrypt() {
        return new EncryptDefaultImpl2();
    }

    private static void decrypt() throws IOException {
        LOGGER.debug("Entering decrypt.");
        displayDecryptOptions();
        processUserInputForDecryption();
        LOGGER.debug("Exiting decrypt.");
    }

    private static void displayDecryptOptions() {
        LOGGER.debug("Entering displayDecryptOptions.");
        System.out.println("Decrypt all the files in the folder '"
                + ENCRYPTED_FOLDER_INPUT + "' ?");
        System.out.println("1. Yes");
        System.out.println("2. No - Decrypt only the default file");
        System.out.println("9. Exit");
        LOGGER.debug("Exiting displayDecryptOptions.");
    }

    private static void processUserInputForDecryption() throws IOException {
        LOGGER.debug("Entering processUserInputForDecryption.");
        scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String choice = nextLine.trim();
            if (choice.equals("1")) {
                LOGGER.debug("Starting Decryption of all files.");
                System.out.println("Starting Decryption of all files.");
                File file = new File(ENCRYPTED_FOLDER_INPUT);
                String[] files = file.list();
                for (int i = 0; i < files.length; i++) {
                    String inputFilepath = ENCRYPTED_FOLDER_INPUT + files[i];
                    LOGGER.debug("Starting Decryption of file: '"
                            + inputFilepath + "'");
                    System.out.println("Starting Decryption of file: '"
                            + inputFilepath + "'");
                    String outputfilePath = DECRYPTED_FOLDER_OUTPUT + files[i];
                    getDecrypt().decrypt(inputFilepath, outputfilePath, currentKey);
                    System.out.println("Completed Decryption of file: '"
                            + inputFilepath + "'");
                }
                System.out.println("Completed Decryption of all files.");
                displayDecryptOptions();
            } else if (choice.equals("2")) {
                String inputFilepath = ENCRYPTED_FILE_INPUT;
                LOGGER.debug("Starting Decryption of file: '" + inputFilepath
                        + "'");
                System.out.println("Starting Decryption of file: '"
                        + inputFilepath + "'");
                String outputfilePath = DECRYPTED_FILE_OUTPUT;
                getDecrypt().decrypt(inputFilepath, outputfilePath, currentKey);
                System.out.println("Completed Decryption of file: '"
                        + inputFilepath + "'");
                displayDecryptOptions();
            } else if (choice.equals("9")) {
                LOGGER.debug("Exiting.");
                System.out.println("Exiting.");
                break;
            } else {
                LOGGER.error("Invalid choice entered.");
                // System.out.print("\033[H\033[2J");
                System.out.println("You have entered an invalid choice.");
                displayDecryptOptions();
            }
        }
        // scanner.close();
        LOGGER.debug("Exiting processUserInputForDecryption.");
    }

    private static Decrypt getDecrypt() {
        return new DecryptDefaultImpl2();
    }
    
    private static void generateKey() throws Exception {
        LOGGER.debug("Entering generateKey.");
		final SecretKey key = KeyGenerator2.createKey();
		String keyKey = BASE_DATA_KEY + "_" + GregorianCalendar.getInstance().getTime();
		//String keyKey = BASE_DATA_KEY;
		KeyStore2.saveKey(key, keyKey);
        LOGGER.debug("keyKey is " + keyKey);
		currentKey = key;
        LOGGER.debug("Exiting generateKey.");
    }
    
    private static void useDefaultKey() throws Exception {
        LOGGER.debug("Entering useDefaultKey.");
		final SecretKey key = KeyStore2.getKey(BASE_DATA_KEY);
        LOGGER.debug("Default keyKey is " + BASE_DATA_KEY);
        LOGGER.debug("Default Key is " + key.getEncoded());
		currentKey = key;
        LOGGER.debug("Exiting useDefaultKey.");
    }
}

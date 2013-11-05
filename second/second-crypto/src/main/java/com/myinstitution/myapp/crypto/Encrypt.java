package com.myinstitution.myapp.crypto;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.crypto.SecretKey;

public interface Encrypt {

    public abstract void encrypt(String inputFilepath, String outputfilePath, SecretKey key)
            throws FileNotFoundException, IOException;

}
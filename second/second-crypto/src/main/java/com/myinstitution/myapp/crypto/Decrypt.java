package com.myinstitution.myapp.crypto;

import java.io.IOException;

import javax.crypto.SecretKey;

public interface Decrypt {

    public abstract void decrypt(String inputFilepath, String outputfilePath, SecretKey key)
            throws IOException;

}
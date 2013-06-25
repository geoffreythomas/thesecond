package com.myinstitution.myapp.crypto;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Encrypt {

    public abstract void encrypt(String inputFilepath, String outputfilePath)
            throws FileNotFoundException, IOException;

}
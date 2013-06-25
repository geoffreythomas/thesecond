package com.myinstitution.myapp.crypto;

import java.io.IOException;

public interface Decrypt {

    public abstract void decrypt(String inputFilepath, String outputfilePath)
            throws IOException;

}
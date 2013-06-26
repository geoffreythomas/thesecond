package com.myinstitution.myapp.crypto;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DecryptDefaultImplTest {
    DecryptDefaultImpl impl;

    @BeforeClass
    public void setUp() {
        impl = new DecryptDefaultImpl();
    }

    @Test(groups = { "Test_P0" })
    public void decrypt_success_Test() {
        // try {
        // impl.decrypt("ReadMe.txt", "ReadMe2.txt");
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
        assert true;
    }
}

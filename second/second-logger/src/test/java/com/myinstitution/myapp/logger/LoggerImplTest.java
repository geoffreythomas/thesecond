package com.myinstitution.myapp.logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoggerImplTest {

    private LoggerImpl loggerImpl;

    @BeforeClass
    public void setUp() {
        loggerImpl = new LoggerImpl();
    }

    @Test(groups = { "Test_P0" })
    public void success_Test() {
        assert loggerImpl.getClass() != null;
    }
}

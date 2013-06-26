package com.myinstitution.myapp.logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoggerFactoryTest {

    // private LoggerFactory loggerFactory;

    @BeforeClass
    public void setUp() {
        // loggerFactory = new LoggerFactory();
    }

    @Test(groups = { "Test_P0" })
    public void success_Test() {
        // assert loggerFactory.getLogger(this.getClass()) instanceof Logger;
    }

    @Test(groups = { "Test_P0" })
    public void successWithStaticMethod_Test() {
        assert LoggerFactory.getLogger(this.getClass()) instanceof org.slf4j.Logger;
    }
}

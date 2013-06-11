package com.myinstitution.myapp.logger;

public class LoggerFactory {

    public static org.slf4j.Logger getLogger(Class<?> clazz) {

        return org.slf4j.LoggerFactory.getLogger(clazz);
    }
}

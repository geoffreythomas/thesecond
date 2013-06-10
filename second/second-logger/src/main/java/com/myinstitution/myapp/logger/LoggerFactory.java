package com.myinstitution.myapp.logger;

public class LoggerFactory {

    public static Logger getLogger(Class<?> clazz) {

        final Logger logger = new LoggerImpl(
                org.slf4j.LoggerFactory.getLogger(clazz));
        return logger;
    }
}

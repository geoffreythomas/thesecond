package com.myinstitution.myapp.logger;

public class LoggerImpl implements Logger {

    private org.slf4j.Logger slf4jLogger;

    public LoggerImpl(org.slf4j.Logger slf4jLogger) {
        super();
        this.slf4jLogger = slf4jLogger;
    }

    public void info(String string) {
        this.slf4jLogger.info(string);
    }

    public void debug(String string) {
        this.slf4jLogger.debug(string);
    }

    public void error(String string) {
        this.slf4jLogger.error(string);
    }
}

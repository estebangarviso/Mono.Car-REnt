package com.mono_car_rent.common.libs;

import org.apache.logging.log4j.LogManager;

public class Logger {
    private org.apache.logging.log4j.Logger logger;
    // Private constructor to hide the implicit public one
    public Logger() {
        String parentClass = Thread.currentThread().getStackTrace()[2].getClassName();
        logger = LogManager.getLogger(parentClass);
    }

    public org.apache.logging.log4j.Logger getLogger() {
        return logger;
    }
}
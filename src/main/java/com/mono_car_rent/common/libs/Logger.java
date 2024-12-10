package com.mono_car_rent.common.libs;

import org.apache.logging.log4j.LogManager;

public class Logger {

    // Private constructor to hide the implicit public one
    private Logger() {
    }
    public static org.apache.logging.log4j.Logger getLogger(Class<?> clazz) {
        return LogManager.getLogger(clazz);
    }
}
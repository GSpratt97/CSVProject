package com.sparta.greg.model;

import com.sparta.greg.controller.EmployeeApp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerClass {
    private static final Logger logger = LogManager.getLogger(EmployeeApp.class);

    public static void logTrace(String message){
        logger.info(message);
    }
    public static void logError(String message){
        logger.error(message);
    }

}

package com.sparta.greg;

import com.sparta.greg.controller.CSVReader;
import com.sparta.greg.model.DataValidation;
import com.sparta.greg.model.EmployeeDTO;
import com.sparta.greg.view.LoggerClass;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TestFiles {
    private static final String DUPLICATES_PATH = "src/main/resources/Duplicates.csv";
    private static final String FILE_PATH = "src/main/resources/EmployeeRecords.csv";
    private static final String FILE_PATH_LARGE = "src/main/resources/EmployeeRecordsLarge.csv";
    private static final String LOGIN_PROPERTIES = "src/main/resources/login.properties";

    @Test
    public void testLoginPropertiesExists() {
        File loginProperties = new File(LOGIN_PROPERTIES);
        boolean exists = loginProperties.exists();
        Assert.assertEquals(true, exists);
    }

    @Test
    public void testCSVExists() {
        File employeeRecords = new File(FILE_PATH);
        boolean exists = employeeRecords.exists();
        Assert.assertEquals(true, exists);
    }

    @Test
    public void testLargeCSVExists() {
        File employeeRecordsLarge = new File(FILE_PATH_LARGE);
        boolean exists = employeeRecordsLarge.exists();
        Assert.assertEquals(true, exists);
    }

    @Test
    public void testDuplicateFileCreated() {
        File duplicates = new File(DUPLICATES_PATH);
        boolean exists = duplicates.exists();
        Assert.assertEquals(true, exists);
    }

    @Test
    public void duplicatesLength() {
        int length = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(DUPLICATES_PATH));
            bufferedReader.readLine();
            while ((bufferedReader.readLine()) != null) {

                length++;
            }

        } catch (IOException e) {
            LoggerClass.logError("Error whilst converting CSV!");
            e.printStackTrace();
        }
        System.out.println(length);
        Assert.assertEquals(114, length);
    }
}

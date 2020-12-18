package com.sparta.greg;

import static org.junit.Assert.assertTrue;

import com.sparta.greg.controller.CSVReader;
import com.sparta.greg.model.EmployeeDAO;
import com.sparta.greg.model.EmployeeDTO;
import org.junit.Test;

import java.util.ArrayList;

public class TestPerformance {
    private static final String FILE_PATH = "src/main/resources/EmployeeRecords.csv";
    private static final String FILE_PATH_LARGE = "src/main/resources/EmployeeRecordsLarge.csv";
    private static final String FILE_PATH_EMPTY = "src/main/resources/EmptyFile.csv";
    private static final String URL = "jdbc:mysql://localhost:3306/employee_database";


    private long timeDataInput(String path) {
        ArrayList<EmployeeDTO> test = CSVReader.readEmployees(path);

//        EmployeeApp employeeApp = new EmployeeApp();
        long start = System.currentTimeMillis();
        EmployeeDAO.connectToDB(URL);
        EmployeeDAO.insertData(test);

//        EmployeeApp.start();
        long end = System.currentTimeMillis();

        return (end - start);
    }

    @Test
    public void testPerformanceTime() {
        System.out.println("Completed in: " + timeDataInput(FILE_PATH) + " ms");
    }

    @Test
    public void testPerformanceTimeLargeFile() {
        System.out.println("Completed in: " + timeDataInput(FILE_PATH_LARGE) + " ms");
    }

    @Test
    public void testPerformanceEmptyFile() {
        System.out.println("Completed in: " + timeDataInput(FILE_PATH_EMPTY) + " ms");
    }
}


// Number of entries = number input
// Test DTO for getters and setters
// File read properly
// Checks duplicates removed
// Size of duplicates + size of clean == size of Input CSV
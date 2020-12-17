package com.sparta.greg.controller;

import com.sparta.greg.model.DataValidation;
import com.sparta.greg.model.EmployeeDTO;
import com.sparta.greg.model.EmployeeFileWriter;
import com.sparta.greg.model.LoggerClass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    private static final String DUPLICATES_PATH = "src/main/resources/Duplicates.csv";

    public static ArrayList<EmployeeDTO> readEmployees(String path) {
        ArrayList<EmployeeDTO> employees = new ArrayList<>();
        String line;

        // Convert to SQL database
        long startReadCSV = System.currentTimeMillis();
        try {
            LoggerClass.logTrace("Converting CSV into SQL database");
            // Read CSV
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                // Create string array for each employee
                String[] arrayColumnValues = line.split(",");
                employees.add(EmployeeDTO.employeeCreator(arrayColumnValues));
            }
        } catch (IOException e) {
            LoggerClass.logError("Error whilst converting CSV!");
            e.printStackTrace();
        }
        System.out.println("File read: "+path);
        long finishReadCSV = System.currentTimeMillis();
        long timeToReadCSV = finishReadCSV - startReadCSV;
        LoggerClass.logTrace("Log time to read CSV file. Time taken: "+ timeToReadCSV + " ms");
        System.out.println("Time taken to read CSV file: "+ timeToReadCSV + " ms");

        long startCheckDuplicates = System.currentTimeMillis();

        ArrayList<EmployeeDTO> cleanEmployees = DataValidation.checkDuplicates(employees, true);
        ArrayList<EmployeeDTO> duplicateEmployees = DataValidation.checkDuplicates(employees, false);
        long finishCheckDuplicates = System.currentTimeMillis();
        long timeToCheckDuplicates = finishCheckDuplicates - startCheckDuplicates;
        System.out.println("Time taken to check duplicates: "+ timeToCheckDuplicates + " ms");

        long startWriteToCSV = System.currentTimeMillis();
        try {
            EmployeeFileWriter.duplicatesToFile(DUPLICATES_PATH , duplicateEmployees);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long finishWriteToCSV = System.currentTimeMillis();
        long timeToWriteToCSV = finishWriteToCSV - startWriteToCSV;
        System.out.println("Time taken to write CSV file: "+ timeToWriteToCSV + " ms");

        System.out.println("Size of clean employees ArrayList: "+ cleanEmployees.size());
        return cleanEmployees;
    }
}

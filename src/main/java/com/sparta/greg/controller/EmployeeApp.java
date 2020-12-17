package com.sparta.greg.controller;

import com.sparta.greg.model.EmployeeDAO;
import com.sparta.greg.model.EmployeeDTO;
import java.util.ArrayList;
import com.sparta.greg.model.LoggerClass;

public class EmployeeApp {
    private static final String FILE_PATH = "src/main/resources/EmployeeRecords.csv";
    private static final String FILE_PATH_LARGE = "src/main/resources/EmployeeRecordsLarge.csv";
    private static final String URL = "jdbc:mysql://localhost:3306/employee_database";

    public static void start() {
        LoggerClass.logTrace("The program has been initialised!");
        ArrayList<EmployeeDTO> test = CSVReader.readEmployees(FILE_PATH);
//        ArrayList<EmployeeDTO> test = CSVReader.readEmployees(FILE_PATH_LARGE);

        EmployeeDAO.connectToDB(URL);

        long startInsertCSV = System.currentTimeMillis();

        EmployeeDAO.insertData(test);
//        Threads.threads(test);
        long finishInsertCSV = System.currentTimeMillis();
        long timeToInsertSQL = finishInsertCSV - startInsertCSV;
        LoggerClass.logTrace("Log time to insert to SQL. Time taken: "+ timeToInsertSQL + " ms");
        System.out.println("Time taken to insert into database: "+ timeToInsertSQL + " ms");

//        EmployeeDAO.queryDB("SELECT * FROM employee_database.employees");

//        EmployeeRepository.employeeRepository(employees);
    }
}

//  For this project, you will be performing a data migration exercise from a CSV file to a SQL database. The file contains details about Employees
//
//  Your program will need to read the data from the CSV file and then import the data into the database. Please note that there may be errors in the CSV file that you need to check for. It is recommend to create some kind of collection to store the invalid employee records so they can be checked later
//
//  The program needs thorough testing at all points to ensure the data migration has taken place correctly. It should also report on the time takes to read the CSV, populate the database and the overall time for the migration
//
//  Be sure to consider the use of design patterns to follow good clean code standards (DTO, DAO)
//
//  Submission:
//  - Code should be hosted on your own Github page with a suitable README.md file
//  - A link to your completed project should be emailed to Manish by 23:59 on 18/12/2020
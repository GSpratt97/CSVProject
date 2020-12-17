package com.sparta.greg.model;

import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeFileWriter {
    public static void duplicatesToFile(String path, ArrayList<EmployeeDTO> duplicateEmployees) throws IOException {
        FileWriter outputFile = new FileWriter(path);
        CSVWriter writer = new CSVWriter(
                outputFile,
                ',',
                CSVWriter.NO_QUOTE_CHARACTER);

        // Add header to CSV
        writer.writeNext(header());

        // Add data to CSV
        for(EmployeeDTO employee : duplicateEmployees) {
            writer.writeNext(employeeToCSV(employee));
        }
        writer.close();
    }

    public static String[] employeeToCSV(EmployeeDTO employee) {
        String[] employeeData = {
                employee.getEmp_ID(),
                employee.getNamePrefix(),
                employee.getFirstName(),
                employee.getMiddleInitial(),
                employee.getLastName(),
                employee.getGender(),
                employee.getEmail(),
                employee.getDob().toString(),
                employee.getDateOfJoining().toString(),
                employee.getSalary().toString()};
        return employeeData;
    }

    public static String[] header() {
        String[] header = {
                "Emp ID",
                "Name Prefix",
                "First Name",
                "Middle Initial",
                "Last Name",
                "Gender",
                "E Mail",
                "Date of Birth",
                "Date of Joining",
                "Salary"
        };
        return header;
    }
}

package com.sparta.greg.model;

import java.util.ArrayList;
import java.util.HashSet;

public class DataValidation {
    public static ArrayList<EmployeeDTO> cleanEmployees;
    public static ArrayList<EmployeeDTO> corruptedEmployees;



    public static ArrayList<EmployeeDTO> checkDuplicates(ArrayList<EmployeeDTO> employees, boolean isClean) {
//    public static ArrayList<EmployeeDTO> checkDuplicates(ArrayList<EmployeeDTO> employees) {
        LoggerClass.logTrace("Check for duplicates and remove both into separate ArrayList");
        ArrayList<EmployeeDTO> cleanEmployees = new ArrayList<>();
        ArrayList<EmployeeDTO> corruptedEmployees = new ArrayList<>();
        HashSet<String> validEmployeesID = new HashSet<>();
        HashSet<String> nonValidEmployeesID = new HashSet<>();

        for (EmployeeDTO employee : employees) {
            if (validEmployeesID.contains(employee.getEmp_ID())) {
                nonValidEmployeesID.add(employee.getEmp_ID());
                corruptedEmployees.add(employee);
            } else {
                validEmployeesID.add(employee.getEmp_ID());
                cleanEmployees.add(employee);
            }
        }
        for (EmployeeDTO employee:employees) {
            for (String id : nonValidEmployeesID ){
                if (employee.getEmp_ID().contains(id) && cleanEmployees.contains(employee)) {
                    cleanEmployees.remove(employee);
                    corruptedEmployees.add(employee);
                }
            }
        }

        LoggerClass.logTrace("Return clean or corrupted employee ArrayList");
        if (isClean) {
            return cleanEmployees;
        } else {
            return corruptedEmployees;
        }
    }
}

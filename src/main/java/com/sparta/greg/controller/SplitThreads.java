package com.sparta.greg.controller;

import com.sparta.greg.model.EmployeeDAO;
import com.sparta.greg.model.EmployeeDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplitThreads {
    public static void demo(ArrayList<EmployeeDTO> test) {
        split(test);
    }

    public static void split(ArrayList<EmployeeDTO> test) {
        new ThreadDemo();
        try {
            int length = test.size();
            System.out.println(length);
            ArrayList<EmployeeDTO> firstQuarter = new ArrayList<>();
            ArrayList<EmployeeDTO> secondQuarter = new ArrayList<>();
            ArrayList<EmployeeDTO> thirdQuarter = new ArrayList<>();
            ArrayList<EmployeeDTO> finalQuarter = new ArrayList<>();

            for (int i = 0; i < length * (1/4); i++) {
                firstQuarter.add(test.get(i));
            }
            for (int i = length * (1/4); i < length * (2/4); i++) {
                secondQuarter.add(test.get(i));
            }
            for (int i = length * (2/4); i < length * (3/4); i++) {
                thirdQuarter.add(test.get(i));
            }
            for (int i = length * (3/4); i < length; i++) {
                finalQuarter.add(test.get(i));
            }

            System.out.println("Main thread");

            EmployeeDAO.insertData(firstQuarter);
            EmployeeDAO.insertData(secondQuarter);
            EmployeeDAO.insertData(thirdQuarter);
            EmployeeDAO.insertData(finalQuarter);

        } catch (Exception e) {
            System.out.println("The main thread is interrupted");
        }
        System.out.println("Exiting the main thread");
    }
}



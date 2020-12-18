package com.sparta.greg.view;

import com.sparta.greg.controller.EmployeeApp;

public class App {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        LoggerClass.logTrace("The program has been initialised!");
        EmployeeApp.start();
        long finish = System.currentTimeMillis();

        System.out.println("Total program time: " +((finish-start)/1000) + " seconds");
    }
}

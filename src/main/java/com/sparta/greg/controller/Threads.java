package com.sparta.greg.controller;

import com.sparta.greg.model.EmployeeDAO;
import com.sparta.greg.model.EmployeeDTO;

import java.util.ArrayList;

public class Threads {
    public static void threads(ArrayList<EmployeeDTO> employees) {
        // Number of threads/arraylist size
        // Find start
        // Use modulus
        EmployeeDAO.insertData(employees);
//        Thread thread1 = new Thread(new LoopOne());


//        int numberOfThreads = 1;
//        try {
//            thread1.start();
//        }
    }

//    public void splitArrayList(ArrayList<EmployeeDTO> listToSplit) {
//        if (listToSplit.size()<1000) {
//            return;
//        }
//
//        int lastIndex = listToSplit.size();
//        int midIndex = (listToSplit.size() / 2);
//
//        ArrayList<EmployeeDTO> firstSplit = new ArrayList<>(listToSplit.subList(0, midIndex));
//        ArrayList<EmployeeDTO> secondSplit = new ArrayList<>(listToSplit.subList(midIndex, lastIndex));
//
//        splitArrayList(firstSplit);
//        splitArrayList(secondSplit);
//    }
}

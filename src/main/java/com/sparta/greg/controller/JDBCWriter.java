import com.sparta.greg.controller.EmployeeApp;
import com.sparta.greg.model.EmployeeDAO;
import com.sparta.greg.model.EmployeeDTO;
import com.sparta.greg.view.LoggerClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

//public class JDBCWriter implements Runnable {
//    private static final String URL = "jdbc:mysql://localhost:3306/employee_database";
//    private static final String userName = "root";
//    private static final String password = "spartaglobal";
//    private final ArrayList<EmployeeDTO> data;
//
////    public jDBCThread(ArrayList<EmployeeDTO> arrayListConstructor) {
////        data = arrayListConstructor;
////    }
//
//    @Override
//    public void run() {
//        try {
//            Connection connection = DriverManager.getConnection(URL, userName, password);
//
//            LoggerClass.logTrace("Start thread for data size of: " + data.size());
//            insertTaskByThread(data, connection);
//
////            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `tester`.`users` (`id`, `user_name`, `email`) VALUES (?,?,?)");
////            preparedStatement.setInt(1, 7);
////            preparedStatement.setString(2, "Manish");
////            preparedStatement.setString(3, "m@g.com");
////            EmployeeDAO.insertData(test);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    private void insertTaskByThread(ArrayList<EmployeeDTO> arrayList, Connection connection) {
//        EmployeeDAO.insertData(arrayList, connection);
//    }
//}



















//package com.sparta.greg.controller;
//
//import com.sparta.greg.model.EmployeeDAO;
//import com.sparta.greg.model.EmployeeDTO;
//
//import java.util.ArrayList;
//
//public class Threads {
////    public static void threads(ArrayList<EmployeeDTO> employees) {
//    public static class HelloWorld implements Runnable {
//        // Number of threads/arraylist size
//        // Find start
//        // Use modulus
//        @Override
//        public void run() {
//            EmployeeDAO.insertData(employees);
//        }
//
//        public static void threads(ArrayList<EmployeeDTO> employees) {
//            Thread thread = new Thread(new HelloWorld(employees));
//            thread.start();
//        }
////        Thread thread1 = new Thread(new LoopOne());
//
//
////        int numberOfThreads = 1;
////        try {
////            thread1.start();
////        }
//    }
//
////    public void splitArrayList(ArrayList<EmployeeDTO> listToSplit) {
////        if (listToSplit.size()<1000) {
////            return;
////        }
////
////        int lastIndex = listToSplit.size();
////        int midIndex = (listToSplit.size() / 2);
////
////        ArrayList<EmployeeDTO> firstSplit = new ArrayList<>(listToSplit.subList(0, midIndex));
////        ArrayList<EmployeeDTO> secondSplit = new ArrayList<>(listToSplit.subList(midIndex, lastIndex));
////
////        splitArrayList(firstSplit);
////        splitArrayList(secondSplit);
////    }
//}

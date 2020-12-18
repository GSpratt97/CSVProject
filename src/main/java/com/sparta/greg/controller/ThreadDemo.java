package com.sparta.greg.controller;

class ThreadDemo implements Runnable {
    Thread thread1;
    Thread thread2;
    ThreadDemo() {
        thread1 = new Thread(this, "Thread1");
        thread2 = new Thread(this, "Thread2" );
//        System.out.println("Child thread: " +thread1);
//        System.out.println("Child thread: " +thread2);

        thread1.start();
        thread2.start();
    }
    public void run() {
        try {
//            System.out.println("Child Thread");
            Thread.sleep(0);
        } catch (InterruptedException e) {
//            System.out.println("Exiting the child thread");
        }
    }
}














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

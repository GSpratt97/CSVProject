package com.sparta.greg.model;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

// Data Access Object - CRUD
public class EmployeeDAO {
    private static Connection connection;
    private static Properties properties = new Properties();

    private static void createProperties() {
        try {
            properties.load(new FileReader("src/main/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void connectToDB(String url) {
        createProperties();
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Connected to Database");
    }

    public static void queryDB(String query) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void insertData(ArrayList<EmployeeDTO> dataToInsert) {
        LoggerClass.logTrace("Insert each line of CSV into database");

        try {
//            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `employee_database`.`employees` (`emp_id`, `name_prefix`, `first_name`, `middle_initial`, `last_name`, `gender`, `email`, `dob`, `date_of_joining`, `salary`) VALUES (?,?,?,?,?,?,?,?,?,?)");
            for (EmployeeDTO dataRows : dataToInsert) {
                preparedStatement.setString(1, dataRows.getEmp_ID());
                preparedStatement.setString(2, dataRows.getNamePrefix());
                preparedStatement.setString(3, dataRows.getFirstName());
                preparedStatement.setString(4, dataRows.getMiddleInitial());
                preparedStatement.setString(5, dataRows.getLastName());
                preparedStatement.setString(6, dataRows.getGender());
                preparedStatement.setString(7, dataRows.getEmail());
                preparedStatement.setDate(8, Date.valueOf(dataRows.getDob()));
                preparedStatement.setDate(9, Date.valueOf(dataRows.getDateOfJoining()));
                preparedStatement.setInt(10, dataRows.getSalary());
                preparedStatement.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

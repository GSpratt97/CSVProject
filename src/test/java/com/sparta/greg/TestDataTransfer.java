package com.sparta.greg;

import com.sparta.greg.controller.CSVReader;
import com.sparta.greg.model.EmployeeDAO;
import com.sparta.greg.model.EmployeeDTO;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestDataTransfer {
    @Test
    public void testingFirstLine() {
//        String testString = "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,2/1/2008,69294";
        EmployeeDTO employee = new EmployeeDTO(
                "198429",
                "Mrs.",
                "Serafina",
                "I",
                "Bumgarner",
                "F",
                "serafina.bumgarner@exxonmobil.com",
                "9/21/1982",
                "2/1/2008",
                "69294");
        Assert.assertEquals("198429", employee.getEmp_ID());
        Assert.assertEquals("Mrs.", employee.getNamePrefix());
        Assert.assertEquals("Serafina", employee.getFirstName());
        Assert.assertEquals("I", employee.getMiddleInitial());
        Assert.assertEquals("Bumgarner", employee.getLastName());
        Assert.assertEquals("F", employee.getGender());
        Assert.assertEquals("serafina.bumgarner@exxonmobil.com", employee.getEmail());
        Assert.assertEquals(LocalDate.parse("1982-09-21"), employee.getDob());
        Assert.assertEquals(LocalDate.parse("2008-02-01"), employee.getDateOfJoining());
        Assert.assertEquals(Integer.valueOf(69294), employee.getSalary());
    }

    @Test
    public void testRandomLine() {
        EmployeeDTO employee = new EmployeeDTO(
                "17460",
                "Mrs.",
                "Marci",
                "B",
                "Mcmann",
                "F",
                "marci.mcmann@shaw.ca",
                "3/26/1978",
                "11/17/2012",
                "100739");
        Assert.assertEquals("17460", employee.getEmp_ID());
        Assert.assertEquals("Mrs.", employee.getNamePrefix());
        Assert.assertEquals("Marci", employee.getFirstName());
        Assert.assertEquals("B", employee.getMiddleInitial());
        Assert.assertEquals("Mcmann", employee.getLastName());
        Assert.assertEquals("F", employee.getGender());
        Assert.assertEquals("marci.mcmann@shaw.ca", employee.getEmail());
        Assert.assertEquals(LocalDate.parse("1978-03-26"), employee.getDob());
        Assert.assertEquals(LocalDate.parse("2012-11-17"), employee.getDateOfJoining());
        Assert.assertEquals(Integer.valueOf(100739), employee.getSalary());
    }

    @Test
    public void testLastLine() {
        EmployeeDTO employee = new EmployeeDTO(
                "133641",
                "Mr.",
                "Chas",
                "F",
                "Hurdle",
                "M",
                "chas.hurdle@gmail.com",
                "4/20/1995",
                "5/28/2016",
                "45102");
        Assert.assertEquals("133641", employee.getEmp_ID());
        Assert.assertEquals("Mr.", employee.getNamePrefix());
        Assert.assertEquals("Chas", employee.getFirstName());
        Assert.assertEquals("F", employee.getMiddleInitial());
        Assert.assertEquals("Hurdle", employee.getLastName());
        Assert.assertEquals("M", employee.getGender());
        Assert.assertEquals("chas.hurdle@gmail.com", employee.getEmail());
        Assert.assertEquals(LocalDate.parse("1995-04-20"), employee.getDob());
        Assert.assertEquals(LocalDate.parse("2016-05-28"), employee.getDateOfJoining());
        Assert.assertEquals(Integer.valueOf(45102), employee.getSalary());
    }
}

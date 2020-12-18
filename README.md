# CSVReader #

Welcome to the CSV reader!

## About ##

This project was built using Intellij within Java and is used to extract data from an inputted CSV file, check the data for duplicates and remove these into another CSV file called Duplicates. Next the program will input the data into an SQL database. 

The program also measures the time taken to complete each task and is displayed via the console.

## How to use ##

1. Open this project in an IDE of your choice.
2. Initialise an SQL database called 'employee_database' with a table called 'employees' in MySQL, the login details will also need to be inputted to the program
3. Run the Main class in the start package.
4. Program will pick pre-selected CSV file on line 18/19 of the EmployeeApp.java class (please select by commenting out non-desired CSV file)
5. Next the CSV file will be read and split into two ArrayLists containing:
	1. The non-duplicated data
	2. The clean data which will be placed in the database
6. The duplicated data will be written to a CSV file called 'Duplicates.csv' where it can be analysed to remove duplicate data.
7. The clean data will be placed into the database.
8. The time taken for the whole process will be printed to the console.
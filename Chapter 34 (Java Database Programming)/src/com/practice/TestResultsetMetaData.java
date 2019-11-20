package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestResultsetMetaData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");

		// Connect to a database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?serverTimezone=UTC",
				"hbstudent", "hbstudent");

		// Create a statement
		Statement statement = connection.createStatement();

		// Execute a statement
		ResultSet resultSet = statement.executeQuery("Select * from enrollment");

		ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

		for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
			System.out.printf("%-12s\t", resultSetMetaData.getColumnName(i));
		}
		System.out.println();
		// Iterate through the result and print the students names
		while (resultSet.next()) {
			for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
				System.out.printf("%-12s\t", resultSet.getObject(i));
			}
			System.out.println();
		}
		
		// Close the connection
		connection.close();
	}
}

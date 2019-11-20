package com.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDataBaseMetaData {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Load the JDBC driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver Loaded");
		
		//Connect to the database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?serverTimezone=UTC", "hbstudent", "hbstudent");
		System.out.println("Database connected");
		
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		
		System.out.println("Database URL: " + databaseMetaData.getURL());
		System.out.println("Database Username: "+ databaseMetaData.getUserName() );
		System.out.println("Database Product Name: " + databaseMetaData.getDatabaseProductName());
		System.out.println("Database Product Version: " + databaseMetaData.getDatabaseProductVersion());
		System.out.println("JDBC driver name: " + databaseMetaData.getDriverVersion());
		System.out.println("JDBC driver major version: " + databaseMetaData.getDriverMajorVersion());
		System.out.println("JDBC driver minor version: " + databaseMetaData.getDriverMinorVersion());
		System.out.println("Max number of connections: " + databaseMetaData.getMaxConnections());
		System.out.println("Max Tablename length: " + databaseMetaData.getMaxTableNameLength());
		System.out.println("Max columns in table: " + databaseMetaData.getMaxColumnsInTable());
		
		connection.close();
	}
}

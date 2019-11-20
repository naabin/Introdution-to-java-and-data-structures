package com.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindUserTables {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		System.out.println("Driver loaded");
		
		//Connect to a database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?serverTimezone=UTC", "hbstudent", "hbstudent");
		
		DatabaseMetaData databaseMetaData = connection.getMetaData();
		
		ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[] {"Table"});
		
		System.out.println("User tables: ");
		while(resultSet.next()) {
			System.out.print(resultSet.getString("TABLE_NAME") + " ");
		}
		
		//Close the connection 
		connection.close();
		
	}

}

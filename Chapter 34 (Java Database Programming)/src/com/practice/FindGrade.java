package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FindGrade extends Application {
	//Statement for executing queries
	private Statement stmt;
	
	private TextField tfSSN = new TextField();
	private TextField tfCourseId = new TextField();
	private Label lblStatus = new Label();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Initialize database connection and create Statement object
		initializeDB();
		
		
		Button btShowGrade = new Button("Show Grade");
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(new Label("SSN"), this.tfSSN, new Label("Course ID"), this.tfCourseId, (btShowGrade));
		
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(hBox, this.lblStatus);
		
		this.tfSSN.setPrefColumnCount(6);
		this.tfCourseId.setPrefColumnCount(6);
		
		btShowGrade.setOnAction(e -> showGrade());
		
		//Create scene and place it in the stage
		Scene scene = new Scene(vBox, 420, 80);
		primaryStage.setTitle("FindGrade");
		primaryStage.setScene(scene);
		primaryStage.show();

		
	}
	
	private void initializeDB() {
		try {
			//Load the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");
			
			//Establish connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?serverTimezone=UTC", "hbstudent", "hbstudent");
			
			System.out.println("Database connected");
			
			//Create a statement
			this.stmt = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void showGrade() {
		String ssn = this.tfSSN.getText();
		String courseId = this.tfCourseId.getText();
		try {
			String queryString = "select firstName, mi, lastName, title, grade from Student, Enrollment, Course"
					+ " where Student.ssn = '" + ssn + "' and Enrollment.courseId= '"+ courseId + "' and "
							+ "Enrollment.courseId = Course.courseId and Enrollment.ssn = Student.ssn";
			
			ResultSet rset = this.stmt.executeQuery(queryString);
			if(rset.next()) {
				String lasName = rset.getString(1);
				String mi = rset.getString(2);
				String firstName = rset.getString(3);
				String title = rset.getString(4);
				String grade = rset.getString(5);
				
				//Display result in label
				this.lblStatus.setText(firstName + " " + mi + " " + lasName + "'s grade on course " + title + " is " + grade);
			}
			else {
				this.lblStatus.setText("Not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}

}

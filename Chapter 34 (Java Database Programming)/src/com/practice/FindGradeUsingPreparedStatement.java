package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FindGradeUsingPreparedStatement extends Application {
	
	//Prepared statement for executing queries;
	private PreparedStatement preparedStatement;
	private TextField tfSSN = new TextField();
	private TextField tfCourseId = new TextField();
	private Label lblStatus = new Label();
	
	private TextField ssn = new TextField();
	private TextField firstName = new TextField();
	private TextField mi = new TextField();
	private TextField lastName = new TextField();
	private TextField phone = new TextField();
	private TextField birthDate = new TextField();
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		//initialize database connection and create a Statement object
		initializeDB();
		
		
		Button btShowGrade = new Button("Show Grade");
		HBox hBox = new HBox(5);
		hBox.getChildren().addAll(new Label("SSN"), this.tfSSN, new Label("Course ID"), this.tfCourseId, (btShowGrade));
		
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(hBox, this.lblStatus);
		
		this.tfSSN.setPrefColumnCount(6);
		this.tfCourseId.setPrefColumnCount(6);
		
		btShowGrade.setOnAction(e -> {
			try {
				showGrade();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		//Create scene and place it in the stage
		Scene scene = new Scene(vBox, 420, 80);
		primaryStage.setTitle("FindGrade");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	private void initializeDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded");
		
		//Establish connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook?serverTimezone=UTC");
		System.out.println("Database connected");
		
		
		String queryString = "select firstName, mi, lastName, title, grade from student, enrollment, course"
				+ " where student.ssn = ?  and enrollment.courseId = ? and enrollment.courseId = course.courseId";
		
		//create a statement
		this.preparedStatement = connection.prepareStatement(queryString);
	}
	
	private void showGrade() throws SQLException {
		String ssn = this.tfSSN.getText();
		String courseId = this.tfCourseId.getText();
		
		this.preparedStatement.setString(1, ssn);
		this.preparedStatement.setString(2, courseId);
		
		ResultSet rset = this.preparedStatement.executeQuery();
		
		if(rset.next()) {
			String lastName = rset.getString(1);
			String mi = rset.getString(2);
			String firstName = rset.getString(3);
			String title = rset.getString(4);
			String grade = rset.getString(5);
			
			
			//Display result in a label
			this.lblStatus.setText(firstName + " " + mi + " " + lastName + "'s grade on course " + title + " " + " is " + grade);
		}
		else {
			this.lblStatus.setText("Not found");
		}
		
	}
	
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

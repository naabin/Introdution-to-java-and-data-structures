package com.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CopyFileToTable extends Application {
	
	//Text file info
	private TextField tfFileName = new TextField();
	private TextArea taFile = new TextArea();
	
	//JDBC and table info
	private ComboBox<String> cboURL = new ComboBox<String>();
	private ComboBox<String> cboDriver = new ComboBox<>();
	private TextField tfUsername = new TextField();
	private PasswordField pfPassword = new PasswordField();
	private TextField tfTableName = new TextField();
	
	private Button btViewFile = new Button("View File");
	private Button btCopy = new Button("Copy");
	private Label lblStatus =  new Label();
	
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.cboURL.getItems().addAll(FXCollections.observableArrayList(
					"jdbc:mysql://localhost/javabook?serverTime=UTC",
					"jdbc:mysql://liang.armstrong.edu/javabook",
					"jdbc:odbc:exampleMDBDataSource",
					"jdbc:oracle:thin:@laing.armstrong.edu:1521:orcl"
				));
		
		this.cboURL.getSelectionModel().selectFirst();
		
		this.cboDriver.getItems().addAll(FXCollections.observableArrayList(
					"com.mysql.cj.jdbc.Driver",
					"sun.jdbc.odbc.dbc0dbcDriver",
					"oracle.jdbc.driver.OracleDriver"
				));
		
		this.cboDriver.getSelectionModel().selectFirst();
		
		//Create UI for connecting to the database
		GridPane gridPane = new GridPane();
		gridPane.add(new Label("JDBC Driver"), 0, 0);
		gridPane.add(new Label("Database URl"), 0, 1);
		gridPane.add(new Label("Username"), 0, 2);
		gridPane.add(new Label("Password"), 0, 3);
		gridPane.add(new Label("Table Name"), 0, 4);
		gridPane.add(this.cboURL, 1, 0);
		gridPane.add(this.cboDriver, 1, 1);
		gridPane.add(this.tfUsername, 1, 2);
		gridPane.add(this.pfPassword, 1, 3);
		gridPane.add(this.tfTableName, 1, 4);
		
		HBox hBoxConnection = new HBox();
		hBoxConnection.getChildren().addAll(this.lblStatus, this.btCopy);
		hBoxConnection.setAlignment(Pos.CENTER_RIGHT);
		
		VBox vBoxConnection = new VBox(5);
		vBoxConnection.getChildren().addAll(new Label("Target Database Table"), gridPane, hBoxConnection);
		
		gridPane.setStyle("-fx-border-color: black;");
		
		BorderPane borderPaneFileName = new BorderPane();
		borderPaneFileName.setLeft(new Label("Filename"));
		borderPaneFileName.setCenter(this.tfFileName);
		borderPaneFileName.setRight(this.btViewFile);
		
		
		BorderPane borderPaneFileContent = new BorderPane();
		borderPaneFileContent.setTop(borderPaneFileName);
		borderPaneFileContent.setCenter(this.taFile);
		
		BorderPane borderPaneFileSource = new BorderPane();
		borderPaneFileSource.setCenter(new Label("Source Text file"));
		borderPaneFileSource.setCenter(borderPaneFileContent);
		
		
		SplitPane splitPane = new SplitPane();
		splitPane.getItems().addAll(borderPaneFileSource, vBoxConnection);
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(splitPane, 1000, 400);
		primaryStage.setTitle("CopyFileToTable");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		this.btViewFile.setOnAction(EventHandler -> showFile());
		this.btCopy.setOnAction(EventHandler -> {
			try {
				copyFile();
			} catch (Exception e) {
				this.lblStatus.setText(e.toString());
			}
		});
		
	}




	private void showFile() {
		Scanner input = null;
		try {
			//Use scanner to read text from the file
			input = new Scanner(new File(this.tfFileName.getText().trim()));
			
			//Read a line and append the line to the text area
			while (input.hasNext()) {
				this.taFile.appendText(input.nextLine() + '\n');
				
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + this.tfFileName.getText());
		}
		finally {
			if( input != null) {
				input.close();
			}
		}
	}




	private void copyFile() throws ClassNotFoundException, SQLException {
		//Load the JDBC driver
		Class.forName(this.cboDriver.getSelectionModel().getSelectedItem().trim());
		
		System.out.println("Driver loaded");
		
		//Establish the connection
		Connection connection = DriverManager.getConnection(this.cboURL.getSelectionModel().getSelectedItem().trim(),
				this.tfUsername.getText().trim(), String.valueOf(this.pfPassword.getText().trim()));
		
		System.out.println("Database connected");
		
		//Read each line from the text file and insert it to the table 
		insertRows(connection);
	}




	private void insertRows(Connection connection) {
		//Build the SQL INSERT statement 
		String sqlInsert = "insert into " + this.tfTableName.getText() + " values (";
		
		//User a scanner to read the text from the file
		Scanner input = null;
		
		//Get file name from the text field
		String filename = this.tfFileName.getText().trim();
		
		try {
			//Create a scanner 
			input = new Scanner(new File(filename));
			
			//Create a statement
			Statement statement = connection.createStatement();
			
			System.out.println("Driver major version? " + connection.getMetaData().getDriverMajorVersion());
			
			//Determine if batchUpdatesSupported is supported
			boolean bathcUpdatesSupported = false;
			
			try {
				if(connection.getMetaData().supportsBatchUpdates()) {
					bathcUpdatesSupported = true;
					System.out.println("batch updated supported");
				}
				else {
					System.out.println("The driver does not support the batch updates");
				}
			} catch (UnsupportedOperationException e) {
				System.out.println("The operation is not supported");
			}
			
			//Determine if the driver is capable of batch updates
			if(bathcUpdatesSupported) {
				//Read a line and add the insert table command to batch
				while (input.hasNext()) {
					statement.addBatch(sqlInsert + input.nextLine() + ")");
					
				}
				statement.executeBatch();
				
				this.lblStatus.setText("Batch updates completed");
			}
			else {
				//Read  a line and execute insert table command
				while(input.hasNext()) {
					statement.executeUpdate(sqlInsert + input.nextLine() + ")");
				}
				this.lblStatus.setText("Single row update completed");
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + filename);
		}
		finally {
			if(input != null) {
				input.close();
			}
		}
		
	}

}

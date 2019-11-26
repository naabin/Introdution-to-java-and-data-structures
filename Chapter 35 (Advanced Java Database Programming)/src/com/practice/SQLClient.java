package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SQLClient extends Application {
	
	//Connection to the databse
	private Connection connection;
	
	//Statement to execute SQL commands
	private Statement statement;
	
	//Text area to enter SQL commands
	private TextArea taSQLCommand = new TextArea();
	
	//Text area to display the results from SQL commands
	private TextArea taSQLResult = new TextArea();
	
	//DBC info for a database connection 
	private TextField username = new TextField();
	private PasswordField password = new PasswordField();
	private ComboBox<String> cboURL = new ComboBox<String>();
	private ComboBox<String> cboDriver = new ComboBox<String>();
	
	
	private Button btExecuteSQL = new Button("Execute SQL command");
	private Button btClearSQLCommand = new Button("Clear");
	private Button btConnectDB = new Button("Connect to the database");
	private Button btClearSQLResult = new Button("Clear Result");
	private Label lblConnectionStatus = new Label("No connection now");

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.cboURL.getItems().addAll(FXCollections.observableArrayList(
				"jdbc:mysql://localhost/javabook?serverTimezone=UTC",
				"jdbc:mysql://localhost/localdb",
				"jdbc:odbc:exampleMDBDatasource",
				"jdbc:oracle:thin:@liang.armstrong.edu:1521:orcl"
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
		gridPane.add(this.cboURL, 1, 0);
		gridPane.add(this.cboDriver, 1, 1);
		gridPane.add(this.username, 1, 2);
		gridPane.add(this.password, 1, 3);
		gridPane.add(new Label("JDBC Driver"), 0, 0);
		gridPane.add(new Label("Database URL"), 0, 1);
		gridPane.add(new Label("Username"), 0, 2);
		gridPane.add(new Label("Password"), 0, 3);
		
		
		HBox hBox = new HBox();
		hBox.getChildren().addAll(this.lblConnectionStatus, this.btConnectDB);
		hBox.setAlignment(Pos.CENTER_RIGHT);
		
		VBox vBox = new VBox(5);
		vBox.getChildren().addAll(new Label("Enter Database Information"), gridPane, hBox);
		
		gridPane.setStyle("-fx-border-color: black;");
		
		HBox hBoxSQLCommand = new HBox(5);
		
		hBoxSQLCommand.getChildren().addAll(this.btClearSQLCommand, this.btExecuteSQL);
		hBoxSQLCommand.setAlignment(Pos.CENTER_RIGHT);
		
		BorderPane borderPaneSqlCommand = new BorderPane();
		
		borderPaneSqlCommand.setTop(new Label("Enter an SQL Command"));
		
		borderPaneSqlCommand.setCenter(new ScrollPane(this.taSQLCommand));
		
		borderPaneSqlCommand.setBottom(hBoxSQLCommand);
		
		HBox hBoxConnectionCommand = new HBox(10);
		
		hBoxConnectionCommand.getChildren().addAll(vBox, borderPaneSqlCommand);
		
		BorderPane borderPaneExecutionResult = new BorderPane();
		
		borderPaneExecutionResult.setTop(new Label("SQL Execution Result"));
		borderPaneExecutionResult.setCenter(this.taSQLResult);
		borderPaneExecutionResult.setBottom(this.btClearSQLResult);
		
		BorderPane borderPane = new BorderPane();
		
		borderPane.setTop(hBoxConnectionCommand);
		borderPane.setCenter(borderPaneExecutionResult);
		
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 1000, 400);
		primaryStage.setTitle("SQLClient");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		this.btConnectDB.setOnAction(e -> connectToDB());
		this.btExecuteSQL.setOnAction(e -> executeSQL());
		this.btClearSQLCommand.setOnAction(e -> this.taSQLCommand.setText(null));
		this.btClearSQLResult.setOnAction(e -> this.taSQLResult.setText(null));
		
	}
	
	/**
	 * Connect to DB
	 */
	private void connectToDB() {
		//Get database information from the user input
		String driver = this.cboDriver.getSelectionModel().getSelectedItem();
		String url = this.cboURL.getSelectionModel().getSelectedItem();
		String username = this.username.getText().trim();
		String password = this.password.getText().trim();
		
		//Connection to the database
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(url, username, password);
			this.lblConnectionStatus.setText("Connected to " + url);
			this.username.setText("");
			this.password.setText("");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Execute SQL commands
	 */
	private void executeSQL() {
		if(this.connection == null) {
			this.taSQLResult.setText("Please connect to a database first");
			return;
		}
		else {
			String sqlCommands = this.taSQLCommand.getText().trim();
			String[] commands = sqlCommands.replace('\n', ' ').split(";");
			
			for(String aCommand: commands) {
				if(aCommand.trim().toUpperCase().startsWith("SELECT")) {
					processSQLSelect(aCommand);
				}
				else {
					processNonSelect(aCommand);
				}
			}
		}
	}

	/**
	 * 
	 * @param aCommand
	 */
	private void processSQLSelect(String sqlCommand) {
		try {
			//Get a new statement for the current connection
			this.statement = this.connection.createStatement();
			
			//Execute a SELECT SQL command
			ResultSet resultSet = this.statement.executeQuery(sqlCommand);
			
			//Find the number of columns in the result set
			int columnCount = resultSet.getMetaData().getColumnCount();
			
			String row = "";
			//Display column names
			for(int i = 1; i <= columnCount; i++) {
				row += resultSet.getMetaData().getColumnName(i) + "\t";
			}
			this.taSQLResult.appendText(row + '\n');
			
			while(resultSet.next()) {
				//Reset row to empty
				row = "";
				
				for(int i = 1; i <= columnCount; i++ ) {
					//A non-string column is converted to a string
					row += resultSet.getString(i) + "\t"; 
				}
				
				this.taSQLResult.appendText(row + '\n');
			}
		} catch (SQLException e) {
		
			this.taSQLResult.setText(e.toString());
		}
	}

	/**
	 * 
	 * @param aCommand
	 * Execute SQL DDL, and modification commands
	 */
	private void processNonSelect(String aCommand) {
		try {
			this.statement = this.connection.createStatement();
			
			//Execute a non-SELECT SQL command
			this.statement.executeUpdate(aCommand);
			
			this.taSQLResult.setText("SQL command executed");
		} catch (SQLException e) {
			this.taSQLResult.setText(e.toString());
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

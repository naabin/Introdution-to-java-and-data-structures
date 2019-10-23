package com.practice;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StudentClient extends Application {
	private TextField tfName = new TextField();
	private TextField tfStreet = new TextField();
	private TextField tfCity = new TextField();
	private TextField tfState = new TextField();
	private TextField tfZip = new TextField();
	private TextField serverResponse = new TextField();
	
	//Button for sending a student to the server
	private Button btRegister = new Button("Register to the server");
	
	//Host name or ip
	String host = "localhost";
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		pane.add(new Label("Name"), 0, 0);
		pane.add(this.tfName, 1, 0);
		pane.add(new Label("Street"), 0, 1);
		pane.add(this.tfStreet, 1, 1);
		pane.add(new Label("City"), 0, 2);
		HBox hBox = new HBox(2);
		pane.add(hBox, 1, 2);
		hBox.getChildren().addAll(this.tfCity, new Label("State"), this.tfState, new Label("Zip"), this.tfZip);
		pane.add(this.btRegister, 1, 3);
		pane.add(new Label("Server response"), 0, 3);
		pane.add(this.serverResponse, 1, 4);
		GridPane.setHalignment(this.btRegister, HPos.RIGHT);
		
		pane.setAlignment(Pos.CENTER);
		this.tfName.setPrefColumnCount(15);
		this.tfStreet.setPrefColumnCount(15);
		this.tfCity.setPrefColumnCount(10);
		this.tfState.setPrefColumnCount(2);
		this.tfZip.setPrefColumnCount(3);
		
		this.btRegister.setOnAction(new ButtonListener());
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(pane, 450, 200);
		primaryStage.setTitle("Student Client");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Handle Button actions
	 */
	private class  ButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			try {
				//Establish connection with the server
				Socket socket = new Socket(host, 8000);
				
				//Create an output stream to the server
				ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
				
//				ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
				
				//Get textfield
				String name = tfName.getText().trim();
				String street = tfStreet.getText().trim();
				String city = tfCity.getText().trim();
				String state = tfState.getText().trim();
				String zip = tfZip.getText().trim();
				
				//Create a student object and send to the server 
				StudentAddress s = new StudentAddress(name, street, city, state, zip);
				toServer.writeObject(s);
				tfName.setText("");
				tfStreet.setText("");
				tfCity.setText("");
				tfState.setText("");
				tfZip.setText("");
				serverResponse.setText("Student added");
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}

}

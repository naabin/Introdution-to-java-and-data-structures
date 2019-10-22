package com.practice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application {

	private DataOutputStream toServer = null;
	private DataInputStream fromServer = null;
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Panel p to hold the label and text field
		BorderPane paneFromTextField = new BorderPane();
		paneFromTextField.setPadding(new Insets(5, 5, 5, 5));
		paneFromTextField.setStyle("-fx-border-color: green");
		paneFromTextField.setLeft(new Label("Enter a radius"));
		
		TextField tf = new TextField();
		tf.setAlignment(Pos.BOTTOM_RIGHT);
		paneFromTextField.setCenter(tf);
		
		BorderPane mainPane = new BorderPane();
		//Text area to display contents
		TextArea ta = new TextArea();
		mainPane.setCenter(new ScrollPane(ta));
		mainPane.setTop(paneFromTextField);
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(mainPane, 450, 200);
		primaryStage.setTitle("Client");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		tf.setOnAction(e -> {
			try {
				double radius = Double.parseDouble(tf.getText().trim());
				//Send the radius to the server
				this.toServer.writeDouble(radius);
				this.toServer.flush();
				
				//Get area from the server
				double area = this.fromServer.readDouble();
				
				//Display to the text area
				ta.appendText("Radius is " + radius + "\n");
				ta.appendText("Area recieved from the server is " + area  + "\n");
				
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		});
		
		try {
			//Create a socket to connect to the server
			Socket socket = new Socket("localhost", 8000);
			
			//Create and input stream to receive data from the server
			this.fromServer = new DataInputStream(socket.getInputStream());
			
			//Create an output stream to send data to the server
			this.toServer = new DataOutputStream(socket.getOutputStream());
			
		} catch (IOException e) {
			ta.appendText(e.toString() + "\n");
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
}

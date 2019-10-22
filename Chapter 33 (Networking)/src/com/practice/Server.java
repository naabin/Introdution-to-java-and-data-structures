package com.practice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Server extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Text area for displaying contents
		
		TextArea ta = new TextArea();
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(ta), 450, 200);
		primaryStage.setTitle("Server");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new Thread(() ->  {
			try {
				//Create a server socket
				ServerSocket serverSocket = new ServerSocket(8000);
				
				Platform.runLater(() -> {
					ta.appendText("Sever started at " + new Date() + '\n');
				});
				
				//Listen for a connection request
				Socket socket = serverSocket.accept();
				
				//Create data input and output streams
				DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
				
				DataOutputStream outputTClient = new DataOutputStream(socket.getOutputStream());
				
				while(true) {
					//Receive radius from the client
					double radius = inputFromClient.readDouble();
					
					//Compute area
					double area = Math.pow(radius, 2) * Math.PI;
					
					//Send area back to the client
					outputTClient.writeDouble(area);
					
					Platform.runLater(() -> {
						ta.appendText("Radius received from client: " + radius + '\n');
						ta.appendText("Area is: " + area + '\n');
					});
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

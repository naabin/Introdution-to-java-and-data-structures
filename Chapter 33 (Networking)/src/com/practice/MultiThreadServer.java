package com.practice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MultiThreadServer extends Application {
	
	//Text area for displaying contents
	private TextArea ta = new TextArea();
	
	//Number of client
	private int client = 0;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(ta), 450, 200);
		primaryStage.setTitle("MultiThreadServer");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		new Thread( () ->  {
			try {
				//Create a server socket
				ServerSocket serverSocket = new ServerSocket(8000);
				ta.appendText("MultiThreadServer started at " + new Date() + "\n");
				
				
				while(true) {
					//Listen for a new connection request 
					Socket socket = serverSocket.accept();
					
					//Increment clientNo
					this.client++;
					
					Platform.runLater(() -> {
						//Display the client number
						ta.appendText("Starting thread for client " + client + " at " + new Date() + "\n");
						
						//Find the client's host name and IP address
						InetAddress inetAddress = socket.getInetAddress();
						this.ta.appendText("Client " + client + "'s host name is " + inetAddress.getHostName() + "\n");
						this.ta.appendText("Client " + this.client + "'s IP addresss is "  +inetAddress.getHostAddress() + "\n");
					});
					//Create and start a new Thread for the connection
					new Thread(new HandleClient(socket)).start();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
	
	//Define the thread class for handling new connection
	private class HandleClient implements Runnable {
		private Socket socket; // A connected socket
		
		public HandleClient(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {
			try {
				DataInputStream inputFromClient = new DataInputStream(this.socket.getInputStream());
				DataOutputStream outputToClient = new DataOutputStream(this.socket.getOutputStream());
				
				//Continuously serve the client
				while(true) {
					//Receive radius from the client 
					double radius = inputFromClient.readDouble();
					
					//Compute area
					double area = Math.PI * Math.pow(radius, 2);
					
					//Send area back to the client 
					outputToClient.writeDouble(area);
					
					Platform.runLater(() -> {
						ta.appendText("radius form client " + radius + '\n');
						ta.appendText("Area found: " + area + "\n");
					});
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}

}

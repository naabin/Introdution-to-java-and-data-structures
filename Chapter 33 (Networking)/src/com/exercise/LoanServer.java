package com.exercise;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

public class LoanServer extends Application {
	
	//Text area for displaying contents
	private TextArea ta = new TextArea();
	
	//Number of client
	private int client = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(this.ta), 450, 200);
		primaryStage.setTitle("Loan Calculating server");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		new Thread(() ->  {
			try {
				ServerSocket serverSocket = new ServerSocket(8000);
				ta.appendText("Server started ad " + new Date() + "\n");
				
				while(true) {
					//Listen for a new connection request
					Socket socket = serverSocket.accept();
					
					//Increment client
					this.client++;
					
					Platform.runLater(() -> {
						//Display the client number
						ta.appendText("Starting thread for client " + this.client + " at " + new Date() + "\n");
						
						//Find the client's host name and IP address
						InetAddress inetAddress = socket.getInetAddress();
						this.ta.appendText("Client " + this.client + "'s host name is " + inetAddress.getHostName() + "\n");
						this.ta.appendText("Client " + this.client + "'s IP address " + inetAddress.getHostAddress() + "\n");
					});
					
					//Create and start an new Thread for the connection
					new Thread(new HandleClient(socket)).start();
					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}).start();
		
	}
	//Define a thread class for handling new connection
	private class HandleClient implements Runnable{
		private Socket socket;
		
		
		public HandleClient(Socket socket) {
			this.socket = socket;
		}
		

		@Override
		public void run() {
			try {
				ObjectInputStream inputFromClient = new ObjectInputStream(this.socket.getInputStream());
				ObjectOutputStream outputToClient = new ObjectOutputStream(this.socket.getOutputStream());
				
				
				//Continuously serve the client
				while(true) {
					//Receive input from the client
					Loan loan = (Loan) inputFromClient.readObject();
					
					//Send back the loaded loan to the client
					outputToClient.writeObject(loan);
					
					Platform.runLater(() -> {
						ta.appendText("Annual Interest: " + loan.getAnnualInterestRate() + "\n");
						ta.appendText("Number of years: " + loan.getNumberOfYears() + "\n");
						ta.appendText("Loan amount: " + loan.getLoanAmount() + "\n");
						ta.appendText("Monthly payment: " + loan.getMonthlyPayment() + "\n");
						ta.appendText("Total payment: " + loan.getTotalPayment() + "\n");
					});
					
					 
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

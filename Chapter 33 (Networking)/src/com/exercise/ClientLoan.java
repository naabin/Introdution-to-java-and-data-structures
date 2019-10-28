package com.exercise;



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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientLoan extends Application {
	
	private TextField annualInterest = new TextField();
	private TextField numYears = new TextField();
	private TextField loan = new TextField();
	
	private TextArea serverResponse = new TextArea();
	
	//Button for sending a loan to the server
	private Button submit = new Button("Calculate");
	
	
	//Host name or IP
	private String host = "localhost";
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		GridPane pane = new GridPane();
		pane.add(new Label("Annual Interest Rate"), 0, 0);
		pane.add(this.annualInterest, 1, 0);
		pane.add(new Label("Number of Years"), 0, 1);
		pane.add(this.numYears, 1, 1);
		pane.add(new Label("Loan Amount"), 0, 2);
		pane.add(this.loan, 1, 2);
		pane.add(this.submit, 1, 3);
		pane.add(new Label("Server Response"), 0, 3);
		pane.add(this.serverResponse, 1, 4);
		GridPane.setHalignment(this.submit, HPos.RIGHT);
		
		pane.setAlignment(Pos.CENTER);
		this.annualInterest.setPrefColumnCount(15);
		this.numYears.setPrefColumnCount(15);
		this.loan.setPrefColumnCount(15);
		this.serverResponse.setPrefColumnCount(15);
		this.serverResponse.setPrefRowCount(5);
		
		this.submit.setOnAction(new ButtonListener());
		
		
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(pane, 450, 200);
		primaryStage.setTitle("Loan Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private class ButtonListener implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			try {
				//Establish connection with the server
				Socket socket = new Socket(host, 8000);
				
				//Create an output stream to server 
				ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
				
				ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
				
				try {
					double annualInterestRate = Double.parseDouble(annualInterest.getText());
					int numberOfYears = Integer.parseInt(numYears.getText());
					double loanAmount = Double.parseDouble(loan.getText());
					
					Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
					
					toServer.writeObject(loan);
					
					
					Loan calculatedLoan = (Loan)fromServer.readObject();
					serverResponse.setText("Annual Interest Rate: " + calculatedLoan.getAnnualInterestRate() + "\n");
					serverResponse.setText("Number of years: " + calculatedLoan.getNumberOfYears());
					serverResponse.setText("Monthly payment: " + calculatedLoan.getMonthlyPayment());
					serverResponse.setText("Total Payment " + calculatedLoan.getTotalPayment());
					
					
					annualInterest.setText("");
					numYears.setText("");
					ClientLoan.this.loan.setText("");
					
					
				} catch (Exception e) {
					serverResponse.appendText("Invalid number format. Please try again");
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

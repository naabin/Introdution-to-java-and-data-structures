package com.practice.tictactoe;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;




public class TicTacToeClient extends Application implements TicTacToeConstants {
	
	//Indicate whether the player has the turn
	private boolean myTurn = false;
	
	//Indicate the token for the player
	private char myToken = ' ';
	
	//Indicate the token for the other player
	private char otherToken = ' ';
	
	//Create and initialize cells
	private Cell[][] cell = new Cell[3][3];
	
	//Create and initialize a title label
	private Label lblTitle = new Label();
	
	//Crate and initialize a status label
	private Label lblStatus = new Label();
	
	//Indicate selected row and column by the current move
	private int rowSelected;
	private int columnSelected;
	
	//Input and output streams from/to server
	private DataInputStream fromServer;
	private DataOutputStream toServer;
	
	//Continue to play
	private boolean continueToPlay = true;
	
	//Wait for the player to mark a cell
	private boolean waiting = true;
	
	//Wait for the player to mark cell
	private String host = "localhost";

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Pane to hold cell
		GridPane pane = new GridPane();
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				pane.add(this.cell[i][j] = new Cell(i,j), j, i);
			}
		}
		BorderPane borderPane = new BorderPane();
		borderPane.setTop(lblTitle);
		borderPane.setCenter(pane);
		borderPane.setBottom(lblStatus);
		
		//Create a scene and place it in the stage
		Scene scene = new Scene(borderPane, 320, 350);
		primaryStage.setTitle("TicTacToeClient");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Connect to the server
		connectToServer();
	}

	private void connectToServer() {
		
		try {
			//Create a socket to connect to the server 
			Socket socket = new Socket(this.host, 8000);
			
			//Create an input stream to receive data from the server
			this.fromServer = new DataInputStream(socket.getInputStream());
			
			//Create and output stream to send data to the server
			this.toServer = new DataOutputStream(socket.getOutputStream());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Control the game on the separate thread
		new Thread(() ->   {
			try {
				//Get notification from the server
				int player = this.fromServer.readInt();
				
				//Am i player 1 or 2 ?
				if(player == PLAYER1) {
					this.myToken = 'X';
					this.otherToken = 'O';
					
					Platform.runLater(() -> {
						this.lblTitle.setText("Player 1 with token X");
						this.lblStatus.setText("Waiting for player to join");
					});
					
					//Receive startup notification from the server
					this.fromServer.readInt();
					
					//The other player has joined
					Platform.runLater(() -> {
						this.lblStatus.setText("Player 2 has joined. I srart first");
					});
					//It is my turn
					this.myTurn = true;
				
				}
				else if(player == PLAYER2) {
					this.myToken = 'O';
					this.otherToken = 'X';
					Platform.runLater(() -> {
						this.lblTitle.setText("Player 2 with token 'O'");
						this.lblStatus.setText("Waiting for player 1 to move");
					});
				}
				//Continue to play
				while(this.continueToPlay) {
					if(player == PLAYER1) {
						waitForPlayerAction();//Wait for player 1 to move
						sendMove(); //Send the move to the server
						receiveInfoFromServer();
					}
					else if(player == PLAYER2) {
						receiveInfoFromServer();
						waitForPlayerAction();
						sendMove();
					}
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}).start();
		
	}

	private void waitForPlayerAction() throws InterruptedException {
		while(this.waiting) {
			Thread.sleep(100);
		}
		
		this.waiting= true;
		
	}

	private void sendMove() throws IOException {
		this.toServer.writeInt(this.rowSelected);
		this.toServer.writeInt(this.columnSelected);
		
	}

	/**
	 * Receive info from server
	 * @throws IOException 
	 */
	private void receiveInfoFromServer() throws IOException {
		int status = this.fromServer.readInt();
		
		if(status == PLAYER1_WON) {
			//Player 1 won, stop playing 
			this.continueToPlay = false;
			if(this.myToken == 'X') {
				Platform.runLater(() -> this.lblStatus.setText("I won! (X)"));
			}
			else if(this.myToken == 'O') {
				Platform.runLater(() -> {
					this.lblStatus.setText("Player 1(X) has won!");
				});
				receiveMove();
			}
		}
		else if(status == PLAYER2_WON) {
			//Player 2 has won, stop playing
			this.continueToPlay = false;
			if(this.myToken == 'O') {
				Platform.runLater(() -> this.lblStatus.setText("I won! (O)"));
			}
			else if(this.myToken == 'X') {
				Platform.runLater(() -> this.lblStatus.setText("Player 2 (O) has won!"));
				receiveMove();
			}
			
		}
		else if(status == DRAW) {
			//No winner, game is over
			this.continueToPlay = false;
			Platform.runLater(() -> this.lblStatus.setText("Game over, no winner!"));
			
			if(this.myToken == 'O') {
				receiveMove();
			}
		}
		else {
			receiveMove();
			Platform.runLater(() -> this.lblStatus.setText("My Turn"));
			this.myTurn = true;
		}
	}

	private void receiveMove() throws IOException {
		//Get the other players move
		int row = this.fromServer.readInt();
		int column = this.fromServer.readInt();
		
		Platform.runLater(() -> this.cell[row][column].setToken(this.otherToken));
	}
	
	//An inner class for a cell
	public class Cell extends Pane{
		//Indicate the row and column of this cell in the board
		private int row;
		private int column;
		
		//Token used for this cell
		private char token = ' ';
		
		
		public Cell(int row, int column) {
			this.row = row;
			this.column = column;
			this.setPrefSize(2000, 2000);
			setStyle("-fx-border-color: black");
			this.setOnMouseClicked(e -> handleMouseClick());
		}
		
		//Return token
		public char getToken() {
			return this.token;
		}
		public void setToken(char c) {
			this.token = c;
			repaint();
		}
		
		private void repaint() {
			if(this.token == 'X') {
				Line line1 = new Line(10, 10, this.getWidth() - 10, this.getHeight() - 10);
				line1.endXProperty().bind(this.widthProperty().subtract(10));
				line1.endYProperty().bind(this.heightProperty().subtract(10));
				Line line2 = new Line(10, this.getHeight()-10, this.getWidth()-10, 10);
				line2.startYProperty().bind(this.heightProperty().subtract(10));
				line2.endXProperty().bind(this.widthProperty().subtract(10));
				
				//Add lines to the pane
				this.getChildren().addAll(line1, line2);
				
			}
			else if(this.token == 'O') {
				Ellipse ellipse = new Ellipse(this.getWidth() / 2, this.getHeight() / 2, this.getWidth()/2 -10, this.getHeight()/2 - 10);
				ellipse.centerXProperty().bind(this.widthProperty().divide(2));
				ellipse.centerYProperty().bind(this.heightProperty().divide(2));
				ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
				ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
				ellipse.setStroke(Color.BLACK);
				ellipse.setFill(Color.WHITE);
				this.getChildren().add(ellipse);
			}
			
		}

		/**
		 * handle
		 * @return
		 */
		private void handleMouseClick() {
			//If cell is not occupied and the player has the turn
			if(this.token == ' ' && myTurn) {
				setToken(myToken);
				myTurn = false;
				rowSelected = row;
				columnSelected = column;
				lblStatus.setText("Waiting for the other player to move");
				waiting = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}

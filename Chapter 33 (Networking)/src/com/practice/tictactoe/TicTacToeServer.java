package com.practice.tictactoe;

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

public class TicTacToeServer extends Application implements TicTacToeConstants {

	private int sessionNo = 1;

	@Override
	public void start(Stage primaryStage) throws Exception {
		TextArea taLog = new TextArea();

		// Create a scene and place it in the stage
		Scene scene = new Scene(new ScrollPane(taLog), 450, 200);
		primaryStage.setTitle("TicTacToeServer");
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		new Thread(() -> {
			try {
				ServerSocket serverSocket = new ServerSocket(8000);
				Platform.runLater(() -> taLog.appendText(new Date() + ": Server started at socket 8000\n"));

				// Ready to create a session for every two players
				while (true) {
					Platform.runLater(() -> taLog
							.appendText(new Date() + ": Wait for players tp join session " + sessionNo + '\n'));

					// Connect to player 1
					Socket player1 = serverSocket.accept();

					Platform.runLater(() -> {
						taLog.appendText(new Date() + ": Player 1 joined session " + sessionNo + '\n');
						taLog.appendText("Player 1's IP address " + player1.getInetAddress().getHostAddress() + '\n');
					});

					// Notify the player is Player 1
					new DataOutputStream(player1.getOutputStream()).writeInt(PLAYER1);

					// Connect to player 2
					Socket player2 = serverSocket.accept();

					Platform.runLater(() -> {
						taLog.appendText(new Date() + ": Player 2 joined session " + sessionNo + '\n');
						taLog.appendText("Player 2's IP address " + player2.getInetAddress().getHostAddress() + '\n');

					});
					// Notify that the player is Player 2
					new DataOutputStream(player2.getOutputStream()).writeInt(PLAYER2);

					// Display this session and increment session number
					Platform.runLater(() -> {
						taLog.appendText(new Date() + ": Start a thread for session " + this.sessionNo++ + '\n');
					});

					// Launch a new thread for this session of two players
					new Thread(new HandleSession(player1, player2)).start();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();

	}

	private class HandleSession implements Runnable, TicTacToeConstants {

		private Socket player1;
		private Socket player2;

		// Create and initialize cells

		private char[][] cell = new char[3][3];

		private DataInputStream fromPlayer1;
		private DataOutputStream toPlayer1;
		private DataInputStream fromPlayer2;
		private DataOutputStream toPlayer2;

		// Continue to play
		private boolean continueToPlay = true;

		/**
		 * Construct a thread
		 */
		public HandleSession(Socket player1, Socket player2) {
			this.player1 = player1;
			this.player2 = player2;

			// Initialize cells
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					this.cell[i][j] = ' ';
				}
			}
		}

		@Override
		public void run() {

			try {
				// Create data input and output streams

				DataInputStream fromPlayer1 = new DataInputStream(this.player1.getInputStream());
				DataOutputStream toPlayer1 = new DataOutputStream(this.player1.getOutputStream());
				DataInputStream fromPlayer2 = new DataInputStream(this.player2.getInputStream());
				DataOutputStream toPlayer2 = new DataOutputStream(this.player2.getOutputStream());

				// Write anything to notify player 1 to start
				// This is just to let player 1 to know to start

				toPlayer1.writeInt(1);

				// Continuously serve the players and determine and report
				// the game status to the players

				while (true) {
					// Receive a move from player 1
					int row = fromPlayer1.readInt();
					int column = fromPlayer1.readInt();

					this.cell[row][column] = 'X';

					// Check if Player 1 wins
					if (isWon('X')) {
						toPlayer1.writeInt(PLAYER1_WON);
						toPlayer2.writeInt(PLAYER1_WON);
						sendMove(toPlayer2, row, column);
						break;
					} else if (isFull()) {
						toPlayer1.writeInt(DRAW);
						toPlayer2.writeInt(DRAW);
						sendMove(toPlayer2, row, column);
						break;
					} else {
						// Notify player 2 to take the turn
						toPlayer2.writeInt(CONTINUE);
						// Send player 1's selected row and column to player 2
						sendMove(toPlayer2, row, column);

					}
					// receive a move from player 2
					row = fromPlayer2.readInt();
					column = fromPlayer2.readInt();
					cell[row][column] = 'O';

					// Check if Player 2 wins
					if (isWon('O')) {
						toPlayer1.writeInt(PLAYER2_WON);
						toPlayer2.writeInt(PLAYER2_WON);
						sendMove(toPlayer1, row, column);
						break;
					} else {
						// Notify player 1 to take the turn
						toPlayer1.writeInt(CONTINUE);

						// Send player 2's selected row and column to player 1
						sendMove(toPlayer1, row, column);
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		private boolean isFull() {
			/**
			 * Determine if the cells are all occupied
			 */
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(cell[i][i] == ' ') {
						return false;
					}
				}
			}
			return true;
		}

		/**
		 * Determine if the player with the specified token wins
		 * @param token
		 * @return
		 */
		private boolean isWon(char token) {
			/**
			 * Check all rowsa
			 */
			for(int i = 0; i < 3; i++) {
				if(this.cell[i][0] == token && this.cell[i][1] == token && this.cell[i][2] == token) {
					return true;
				}
			}
			/**
			 * Check all columns
			 */
			for(int j = 0; j < 3; j++) {
				if(this.cell[0][j] == token && this.cell[1][j] == token && this.cell[2][j] == token){
					return true;
				}
				/**
				 * Check major diagonal
				 */
				if(this.cell[0][0] == token && this.cell[1][1] == token && this.cell[2][2] == token) {
					return true;
				}
				
				/**
				 * Check subdiagonal
				 */
				if(this.cell[0][2] == token && this.cell[1][1] == token && this.cell[2][0] == token) {
					return true;
				}
				
				
				
			}
			
			return false;
		}

		private void sendMove(DataOutputStream out, int row, int column) throws IOException {
			out.writeInt(row);
			out.writeInt(column);
		}

	}
	
	public static void main(String[] args) {
		Application.launch(args);
		
	}

}

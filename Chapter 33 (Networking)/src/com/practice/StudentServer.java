package com.practice;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {

	private ObjectOutputStream outputToFile;
	private ObjectInputStream inputFromClient;
	private ObjectOutputStream outputToClient;
	private int count = 0;
	
	public StudentServer() {
		try {
			//Create a server socket 
			ServerSocket serverSocket = new ServerSocket(8000);
			System.out.println("Server started");
			
			//Create an object output stream
			this.outputToFile = new ObjectOutputStream(new FileOutputStream("student.dat", true));
			
			while(true) {
				//Listen for a new connection request 
				Socket socket = serverSocket.accept();
				
				//Create an input stream from the socket
				this.inputFromClient = new ObjectInputStream(socket.getInputStream());
				
				//Read from input
				Object object = inputFromClient.readObject();
				
				//Write to the file
				this.outputToFile.writeObject(object);
				this.count += 1;
				this.outputToClient = new ObjectOutputStream(socket.getOutputStream());
				this.outputToClient.writeObject("A new student object is created and stored with an id " + this.count);
				System.out.println("A new student object is stored");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		finally {
			try {
				this.inputFromClient.close();
				this.outputToFile.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new StudentServer();
	}
}

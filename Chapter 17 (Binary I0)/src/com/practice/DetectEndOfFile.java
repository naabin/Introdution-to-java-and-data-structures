package com.practice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DetectEndOfFile {
	
	public static void main(String[] args) throws IOException, EOFException {
		try {
			try(DataOutputStream output = new DataOutputStream(new FileOutputStream("test.dat"))){
				output.writeDouble(4.5);
				output.writeDouble(43.5);
				output.writeDouble(3.2);
			}
			
			try(DataInputStream input = new DataInputStream(new FileInputStream("test.dat"))){
				while(true) {
					System.out.println(input.readDouble());
				}
			}
		}
		catch(EOFException ex) {
			System.out.println("All data were read");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}

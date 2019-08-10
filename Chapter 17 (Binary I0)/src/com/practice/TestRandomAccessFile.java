package com.practice;

import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {
	
	public static void main(String[] args) throws IOException {
		
		
		try(
			RandomAccessFile input = new RandomAccessFile("inout.dat", "rw");
				
			){
			//Clear the file to destroy the old contents if exists
			input.setLength(0);
			
			for(int i = 0; i < 200; i++) {
				input.writeInt(i);
				
			}
			//Display the current length if the file
			System.out.println("Current file length is " + input.length());
			
			//Retrieve the first number
			input.seek(0);
			System.out.println("The first number is " + input.readInt());
			
			input.seek(1 * 4);
			System.out.println("The second number is " + input.readInt());
			
			
			input.seek(9 * 4);
			System.out.println("The tenth number is " + input.readInt());
			
			input.writeInt(555);
			
			input.seek(input.length());
			input.writeInt(999);
			
			System.out.println("The new length is " + input.length());
			
			input.seek(10 * 4);
			System.out.println("The eleventh number is " + input.readInt());
		}
	}

}

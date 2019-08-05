package com.practice;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {

	public static void main(String[] args) throws IOException {
		
		//Create an output stream to the file
		FileOutputStream output = new FileOutputStream("temp.dat");
		
		for(int i = 0; i <= 10; i++) {
			output.write(i);
		}
		
		FileInputStream input = new FileInputStream("temp.dat");
		
		int value;
		while((value = input.read()) != -1) {
			System.out.println(value + " ");
		}
		
		output.close();
		input.close();
		
	}
}

package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectStreamForArray {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		int[] numbers = {1, 2, 3, 4, 5};
		String[] strings = {"John", "Susan", "Kim"};
		
		try(
				//Create an output stream for file array.dat)
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat", true));
			){
			
			output.writeObject(numbers);
			output.writeObject(strings);
			
			try(
					ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"));
						
					){
				
				int[] newNumbers = (int[])input.readObject();
				String[] newStrings = (String[])input.readObject();
				
				for(Integer i: newNumbers) {
					System.out.print(i +" ");
				}
				System.out.println();
				for(String s: newStrings) {
					System.out.print(s +" ");
				}
			}
			
			
		}
				
				
	}

}

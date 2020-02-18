package com.chapter1.practice;

import java.util.Scanner;

public class BinaryRepresentation {
	
	
	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		
		System.out.println("The binary version of the number is as follows: " + toBinaryString(number));
		
		input.close();
	}
	
	public static String toBinaryString(int number) {
		String toBinaryString = "";
		
		for(int i = number; i > 0; i /= 2) {
			toBinaryString = (i % 2) + toBinaryString;
		}
		
		return toBinaryString;
	}

}

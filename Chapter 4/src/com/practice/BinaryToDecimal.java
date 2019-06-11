package com.practice;

import java.util.Scanner;

public class BinaryToDecimal {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter binary digits (0000 to 1111): ");
		int number = 0;
		
		String binary = input.nextLine();
		for(int i = binary.length(); i > 0; i--) {
			if(binary.charAt(i-1) == '1') {
				number += Math.pow(2, i-1);	
			}
		}
		System.out.println("The decimal value is: " + number);
		
		input.close();
		
	}


}

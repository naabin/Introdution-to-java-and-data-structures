package com.exercise;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		
		String string = input.next();
		String reverseString = "";
		for(int i = 0; i < string.length(); i++) {
			reverseString += string.charAt((string.length()-1)-i);
		}
		System.out.println("The reversed strign is " + reverseString);
		input.close();
	}

}

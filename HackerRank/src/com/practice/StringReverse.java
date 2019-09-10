package com.practice;

import java.util.Scanner;

public class StringReverse {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String A = in.next();
		in.close();
		
		String reveseWord = "";
		for(int i = A.length() - 1; i >= 0; i--) {
			reveseWord += A.charAt(i);
		}
		System.out.println("Original: " +  A);
		System.out.println("Reversed: " + reveseWord);
		
		boolean equals = A.equals(reveseWord);
		String message = equals ? "Yes": "No";
		System.out.println(message);
	}
}

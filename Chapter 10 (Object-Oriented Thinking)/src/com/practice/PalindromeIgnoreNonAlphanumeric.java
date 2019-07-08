package com.practice;

import java.util.Scanner;

public class PalindromeIgnoreNonAlphanumeric {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String string = input.nextLine();
		
		//Display result
		System.out.println("Ignoring nonalphanumeric characters, \nis " + string + " a palindrome? " + isPalindrome(string));
		
		input.close();

	}

	private static boolean isPalindrome(String string) {
		//Create a new string by eliminating nonalphanumeric chars
		String s1 = filter(string);
		
		//Create a new string that is reversal of s1
		String s2 = reverse(string);
		return s2.equals(s1);
	}

	private static String filter(String string) {
		StringBuilder stringBuilder = new StringBuilder();
		//Examine each chat in the string to skip alphanumeric chars
		for (int i = 0; i < string.length(); i++) {
			if(Character.isLetterOrDigit(string.charAt(i))) {
				stringBuilder.append(string.charAt(i));
			}
		}
	
		return stringBuilder.toString();
	}

	private static String reverse(String string) {
		StringBuilder stringBuilder = new StringBuilder(string);
		stringBuilder.reverse();
		
		return stringBuilder.toString();
	}

}

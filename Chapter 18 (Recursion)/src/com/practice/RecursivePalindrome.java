package com.practice;

import java.util.Scanner;

public class RecursivePalindrome {
	
	
	public static boolean isPalindrome(String s) {
		return isPalindrome(s, 0, s.length() - 1);
	}

	private static boolean isPalindrome(String s, int low, int high) {
		if(high <= low) {
			return true;
		}
		else if(s.charAt(low) != s.charAt(high)) {
			return false;
		}
		else {
			return isPalindrome(s, low + 1, high-1);
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a word to figure out whether it is a palindrome or not: ");
		String s = input.nextLine();
		
		if(isPalindrome(s)) {
			System.out.println("The word " + s + " is palindrome.");
		}
		else {
			System.out.println("The word " + s + " is not a palindrome.");
		}
		
		input.close();
	}

}

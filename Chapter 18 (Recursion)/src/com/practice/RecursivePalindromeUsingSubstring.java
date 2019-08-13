package com.practice;

import java.util.Scanner;

public class RecursivePalindromeUsingSubstring {
	
	public static boolean isPalindrome(String s) {
		if(s.length() <= 1) {
			return true;
		}
		else if(s.charAt(0) != s.charAt(s.length() - 1)) {
			return false;
		}
		else {
			return isPalindrome(s.substring(1, s.length() - 1));
		}
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a word to check whether the word is palindrome. ");
		String s = input.nextLine();
		
		if(isPalindrome(s)){
			System.out.println(s + " is a palindrome.");
		}
		else {
			System.out.println(s + " is not a palindrome.");
		}
		
		input.close();
	}

}

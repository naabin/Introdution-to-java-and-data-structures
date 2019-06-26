package com.exercise;

import java.util.Scanner;

public class PalindromeInteger {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer to reverse: ");
		int number = input.nextInt();
		System.out.println("The reversed integer of " + number + " is " + reverse(number));
		if(isPalindrome(number)) {
			System.out.println("The entered number " + number + " happens to be palindrome as well.");
		}
		else {
			System.out.println("The entered number " + number  + " is not a palindrome"); 
		}
		input.close();

	}

	public static int reverse(int number) {
		int reversedNum = 0;
		while (number > 0) {
			reversedNum = reversedNum * 10 + number % 10;
			number = number / 10;
		}
		return reversedNum;

	}

	public static boolean isPalindrome(int number) {
		boolean isPalindrome = false;
		if (reverse(number) == number) {
			isPalindrome = true;
		} else {
			isPalindrome = false;
		}
		return isPalindrome;
	}
}

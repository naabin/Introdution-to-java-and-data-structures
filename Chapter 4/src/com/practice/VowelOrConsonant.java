package com.practice;

import java.util.Scanner;

public class VowelOrConsonant {

	public static void main(String[] args) {
		char[] vowel = { 'a', 'e', 'i', 'o', 'u' };

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a letter: ");
		String message = "";
		String letter = input.next();
		for (int i = 0; i < vowel.length; i++) {
			if (Character.isLowerCase(letter.charAt(0)) && letter.charAt(0) == vowel[i]) {
				message = letter + " is a vowel";
			} else if (Character.isUpperCase(letter.charAt(0)) && (letter.toLowerCase().charAt(0) == vowel[i])) {
				message = letter + " is a vowel";
			}
		}
		if (!Character.isLetter(letter.charAt(0))) {
			message = letter + " is an invalid input";
		}
		System.out.println(message);
		input.close();

	}
}

package com.sololearn;

import java.util.Scanner;

public class PasswordValidation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String answer = "weak";
		if(input.length() >= 7) {
			if (containsTwoNumbers(input)) {
				if (containsSpecialCharacters(input)) {
					answer = "Strong";
				}
			}
		}
		System.out.println(answer);
		scanner.close();
		
	}
	
	public static boolean containsTwoNumbers(String input) {
		boolean check = false;
		int count = 0;
		for (int i = 0; i < input.length(); i++) {
			if(Character.isDigit(input.charAt(i))) {
				count++;
			}
		}
		if (count >= 2) {
			check = true;
		}
		return check;
	}
	
	public static boolean containsSpecialCharacters(String input) {
		boolean check = false;
		int count = 0;
		String specialChars = "!@#$&%*";
		for (int i = 0; i < specialChars.length(); i++) {
			for (int j = 0; j < input.length(); j++) {
				if (specialChars.charAt(i) == input.charAt(j)) {
					count++;
				}
			}
		}
		if (count>=2) {
			check = true;
		}
		return check;
	}
}

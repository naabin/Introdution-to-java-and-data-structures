package com.sololearn;

import java.util.Scanner;

public class PasswordValidator {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to password validator.");
		System.out.println("Press 1 to exit.");
		System.out.print("Enter the password: ");
		
		while(!in.hasNextInt()) {
			String password = in.nextLine();
			String regex = "(^(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{5,10}$)";
			System.out.println("The password " + password + " is " + (password.matches(regex) ? "Valid" : "Invalid"));
		}
		System.out.println("GoodBye!!!");
		in.close();
		
	}

}

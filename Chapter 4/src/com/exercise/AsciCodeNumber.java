package com.exercise;

import java.util.Scanner;

public class AsciCodeNumber {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a character: ");
		String character = input.next();
		
		if(character.length() != 1) {
			System.out.println("Invalid input. Enter only one character at a time.");
			System.exit(1);
		}
		
		int hashCode = Character.hashCode(character.charAt(0));
		
		System.out.println("The ASCII code for the character " + character + " is " + hashCode);
		
		input.close();
		
	}

}

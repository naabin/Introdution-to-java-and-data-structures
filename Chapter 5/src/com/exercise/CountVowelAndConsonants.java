package com.exercise;

import java.util.Scanner;

public class CountVowelAndConsonants {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String words = input.nextLine();
		String string = words.replaceAll(" ", "");
		string = string.toUpperCase();
		String  vowels = "AEIOU";
		int vowelCount = 0;
		int consonantCount = 0;
		for(int i = 0 ; i < string.length(); i++) {
			for(int j = 0; j < vowels.length(); j++) {
				if(string.charAt(i) == vowels.charAt(j)) {
					vowelCount += 1;
				}
			}
			consonantCount += 1;
		}
		consonantCount = consonantCount - vowelCount;
		System.out.println("The number of vowels is " + vowelCount);
		System.out.println("The number of consonants is " + consonantCount);
		input.close();
	}

}

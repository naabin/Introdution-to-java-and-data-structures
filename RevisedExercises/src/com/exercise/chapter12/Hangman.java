package com.exercise.chapter12;


import java.util.Arrays;
import java.util.Scanner;

public class Hangman {
	
	public static void main(String[] args) {
		String words[] = {"program", "name", "hello", "java", "javascript"};
		Scanner input = new Scanner(System.in);
		int randomWordIndex = (int)(Math.random() * words.length);
		String[] characterStrings = words[randomWordIndex].split("");
		String[] duplicateStrings = new String[characterStrings.length];
		
		for(int i = 0; i < duplicateStrings.length; i++) {
			duplicateStrings[i] = "*";
		}
		int missed = 0;
		String string = Arrays.toString(duplicateStrings);
		while(String.join("", duplicateStrings).contains("*")) {
			Arrays.toString(duplicateStrings);
			string = String.join("", duplicateStrings);
			System.out.print("(Guess) Enter a letter in word " + string + " > ");
			String next = input.next();
			characterStrings.toString();
			if(!String.join("", characterStrings).contains(next)) {
				System.out.println(next + " does not contain in the word.");
				missed++;
			}
			else {
				for(int i = 0; i < characterStrings.length; i++) {
					if(characterStrings[i].equals(next)) {
						duplicateStrings[i] = next;
					}
					else if(string.contains(next)) {
						System.out.println("You have already entered the letter.");
						break;
					}
				}
			}

			continue;
			
		}
		System.out.println("The word is " + string	 + " you missed " + missed + " times.");
		
		input.close();
		
	}

}

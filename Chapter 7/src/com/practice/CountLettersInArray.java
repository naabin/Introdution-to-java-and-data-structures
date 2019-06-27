package com.practice;

public class CountLettersInArray {

	public static void main(String[] args) {
		//Declare and create an array
		char[] chars = createArray();
		
		//Display the array
		System.out.println("The lowecase letters are: ");
		displayArray(chars);
		
		//Count the occurrences of each letter
		int [] counts = countLetters(chars);
		
		//Display counts
		System.out.println();
		System.out.println("The occurrences of each letter are: ");
		displayCounts(counts);
	}
	

	/**
	 * 
	 * @return an array of characters
	 */
	private static char[] createArray() {
		char[] chars = new char[1000];
		// Create lower case letters randomly and assign 
		// them to the array
		for(int i = 0; i < chars.length; i++) {
			chars[i] = RandomCharacter.getRandomLowerCaseLetter();
		}
		return chars;
		
	}
	/**
	 * Display the array of characters
	 * @param chars
	 */
	private static void displayArray(char[] chars) {
		//Display the characters in the array 20 on each line
		for(int i = 0; i < chars.length; i++) {
			if((i+1) % 20 == 0) {
				System.out.println(chars[i]);
			}
			else {
				System.out.print(chars[i]+ " ");
			}
		}
	}
	/**
	 * 
	 * @param chars
	 * @return count the occurrences of each letter
	 */
	private static int[] countLetters(char[] chars) {
		int [] counts = new int[26];
		//For each lowercase letter in the array, count it
		for( int i = 0; i < chars.length; i++) {
			counts[chars[i] - 'a']++;
		}
		return counts;
	}
	
	/**
	 * Display counts
	 * @param counts
	 */
	private static void displayCounts(int[] counts) {
		for(int i = 0; i < counts.length; i++) {
			if((i % 10) == 0) {
				System.out.println(counts[i] + " "+ (char)(i + 'a'));
			}
			else {
				System.out.print(counts[i] + " "+ (char)(i + 'a') + " ");
			}
		}
	}





}

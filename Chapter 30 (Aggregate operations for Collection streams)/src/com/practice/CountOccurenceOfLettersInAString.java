package com.practice;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOccurenceOfLettersInAString {
	private static int count = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String s = input.nextLine();
		
		count = 0; //Reset the count for columns
		System.out.print("The occurences of each letter are: ");
		Stream.of(toCharacterArray(s.toCharArray()))
			.filter(Character :: isLetter)
			.map(Character :: toUpperCase)
			.collect(Collectors.groupingBy(e -> e, TreeMap :: new, Collectors.counting()))
			.forEach((k, v) -> {
				System.out.print(v + " " + k + (++count % 10 == 0 ? "\n" : " "));
			});
		
		input.close();
	}
	
	public static Character[] toCharacterArray(char[] list) {
		Character[] result = new Character[list.length];
		for(int i = 0; i < result.length; i++) {
			result[i] = list[i];
		}
		return result;
	}

}

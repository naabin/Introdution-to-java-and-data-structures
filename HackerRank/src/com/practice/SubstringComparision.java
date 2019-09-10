package com.practice;

import java.util.Scanner;

public class SubstringComparision {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a word: ");
		String s = in.next();
		System.out.print("Enter a number: ");
		int k = in.nextInt();
		in.close();
		
		System.out.println(getSmallestAndLargest(s, k));
		
	}
	
	public static String getSmallestAndLargest(String s, int k) {
		String currentSubstring = s.substring(0, k);
		String smallest = currentSubstring;
		String largest = currentSubstring;
	
		for(int i = k; i < s.length(); i++) {
			currentSubstring  = currentSubstring.substring(1, k) + s.charAt(i);
			if(largest.compareTo(currentSubstring) < 0) {
				largest = currentSubstring;
			}
			if(smallest.compareTo(currentSubstring) > 0) {
				smallest = currentSubstring;
			}
		}
		
		
		
		return smallest + "\n" + largest;
	}

}

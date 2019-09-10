package com.practice;

import java.util.Scanner;

public class StringIntro {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter first string: ");
		String s1 = in.next();
		System.out.print("Enter secods string: ");
		String s2 = in.next();
		
		in.close();
		
		 int totalLength = s1.length() + s2.length();
		 int compareTo = s1.compareTo(s2);
		 String message = compareTo > 0 ? "Yes" : "No";
		 
		 String initCapS1 = s1.substring(0, 1).toUpperCase().concat(s1.substring(1));
		 String initCapS2 = s2.substring(0, 1).toUpperCase().concat(s2.substring(1));
		 
		 String concatWords = initCapS1 + " " + initCapS2;
		 
		 System.out.println(totalLength);
		 System.out.println(message);
		 System.out.println(concatWords);
		 
	}

}

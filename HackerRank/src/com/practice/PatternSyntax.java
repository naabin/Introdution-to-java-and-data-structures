package com.practice;

import java.util.Scanner;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class PatternSyntax {
	
	public static void main(String [] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("How many test cases you would like to check: ");
		int testCases = Integer.parseInt(in.nextLine());
		
		while(testCases > 0) {
			String regex = in.nextLine();
			try {
				Pattern pattern  = Pattern.compile(regex);
				System.out.println(pattern);
				System.out.println("Valid");
			}catch(PatternSyntaxException e) {
				System.out.println("Invalid");
			}
			testCases--;
		}
		in.close();
	}

}

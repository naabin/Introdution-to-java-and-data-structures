package com.practice;

import java.util.Scanner;


public class StringTokens {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		
		String strings = s.trim();
		String[] splitStrings = strings.split("[!,?._'@]+");
		int count = 0;
		if(!s.trim().isEmpty()) {
			count = splitStrings.length;
		}
		System.out.println(count);
		for(String string: splitStrings) {
			System.out.println(string);
		}
		in.close();
	}

}

package com.practice;

import java.util.Scanner;

public class JavaSubstring {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String s = input.next();
		int start = input.nextInt();
		int end = input.nextInt();
		
		
		input.close();
		
		System.out.println(s.substring(start, end));
	}

}

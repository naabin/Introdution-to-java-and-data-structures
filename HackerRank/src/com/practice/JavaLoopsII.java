package com.practice;

import java.util.Scanner;

public class JavaLoopsII {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter how many series you would like to evaluate: ");
		int t = in.nextInt();
		
		for(int i = 0; i < t; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();
			
			String s = "";
			int result = a;
			for(int j = 0; j < n; j++) {
				result += ((int)(Math.pow(2, j)) * b);
				s += result + " ";
			}
			
			System.out.println(s);
		}
		in.close();
	}

}

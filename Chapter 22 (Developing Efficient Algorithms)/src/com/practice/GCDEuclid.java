package com.practice;

import java.util.Scanner;

public class GCDEuclid {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter first integer: ");
		int m = in.nextInt();
		System.out.print("Enter second integer: ");
		int n = in.nextInt();
		
		System.out.println("The greatest common divisor for " + m + " and " + n + " is " + gcd(m, n));
		
		in.close();
		
	}
	
	public static int gcd(int m, int n) {
		if(m % n == 0) {
			return n;
		}
		else return gcd(n, m % n);
	}

}

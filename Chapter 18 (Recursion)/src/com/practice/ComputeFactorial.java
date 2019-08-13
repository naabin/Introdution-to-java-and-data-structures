package com.practice;

import java.util.Scanner;

public class ComputeFactorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a nonnegative integer: ");
		
		int n = input.nextInt();
		
		long fact = factorial(n);
		
		System.out.println("Factorial of " + n + " is " + fact);
		
		input.close();
	}

	private static long factorial(int n) {
		if(n ==0) {
			return 1;
		}
		else {
			return  n * factorial(n - 1);
		}
	}
}

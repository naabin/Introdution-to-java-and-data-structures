package com.practice;

import java.util.Scanner;

public class ComputeFactorialTailRecursion {
	public static long factorial(int n) {
		return factorial(n, 1);
	}

	private static long factorial(int n, int result) {
		if(n == 0) {
			return result;
		}
		else {
			return factorial(n-1, n* result);
		}
	}
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer to calculate factorial: ");
		int n = input.nextInt();
		
		long factorial = ComputeFactorialTailRecursion.factorial(n);
		System.out.println("The factorial of " + n + " is " + factorial);
		
		input.close();
	}
}

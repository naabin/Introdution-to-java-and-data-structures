package com.practice;

import java.math.BigInteger;
import java.util.Scanner;

public class LargeFactorial {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int n = input.nextInt();
		
		System.out.println(n + "! is \n" + factorial(n));
		input.close();
	}

	private static BigInteger factorial(int n) {
		BigInteger result = BigInteger.ONE;
		for(int i = 1; i <= n; i++) {
			result = result.multiply(new BigInteger(i + ""));
		}
		return result;
	}

}

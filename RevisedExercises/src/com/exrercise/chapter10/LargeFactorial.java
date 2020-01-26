package com.exrercise.chapter10;

import java.math.BigInteger;
import java.util.Scanner;

public class LargeFactorial {
	
	public static void main(String[] args) {
		System.out.print("Enter an integer to calculate the factorial: ");
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		System.out.println(num + "! = " + largeFactorial(num));
		scanner.close();
		
	}
	
	public static BigInteger largeFactorial(int number) {
		BigInteger result = BigInteger.ONE;
		for(int i = 1; i <= number; i++) {
			result = result.multiply(new BigInteger(i + ""));
		}
		return result;
	}

}

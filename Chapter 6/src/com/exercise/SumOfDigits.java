package com.exercise;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter and integer: ");
		int number = input.nextInt();
		
		System.out.println("The given number " + number + " sum is " + sumDigits(number));
		input.close();
		
	}
	
	public static int sumDigits(long n) {
		int sum = 0;
		while(n > 0) {
			sum += (n%10);
			n = n/10;
		}
		return sum;
	}
}

package com.exercise;

import java.util.Arrays;
import java.util.Scanner;

import com.practice.StackOfIntegers;


public class PrimeFactors {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int num = input.nextInt();

		StackOfIntegers stackOfPrimeNumbers = new StackOfIntegers();
		
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				stackOfPrimeNumbers.push(i);
				num = num/i;
			}
			
		}
		int[] reversedStackOfPrimeIntegers = new int[stackOfPrimeNumbers.getSize()];
		for(int i = 0; i <= stackOfPrimeNumbers.getSize(); i++) {
			reversedStackOfPrimeIntegers[i] = stackOfPrimeNumbers.pop();
		}
		System.out.println(Arrays.toString(reversedStackOfPrimeIntegers));
		input.close();
		

	}
	
}

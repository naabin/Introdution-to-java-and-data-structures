package com.excercise;

import java.util.Scanner;

public class CompareNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[]numbers = new int[11];
		System.out.print("Enter 11 integers: ");
		for(int i = 0; i < numbers.length; i++ ) {
			numbers[i] = input.nextInt();
		}
		
		for(int i = 0; i < numbers.length; i++) {
			if((numbers.length-1) == numbers[i]) {
				System.out.println("Number " + numbers[i] + " is equal to " + numbers[numbers.length-1]);
			}
			else if((numbers.length - 1) > numbers[i]) {
				System.out.println("Number " + numbers[i] + " is smaller than " + numbers[numbers.length-1]);
			}
			else {
				System.out.println("Number " + numbers[i] + " is greater than " + numbers[numbers.length-1]);
			}
		}
		
		input.close();
	}
	

}

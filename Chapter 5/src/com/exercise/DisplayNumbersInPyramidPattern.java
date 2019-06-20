package com.exercise;

import java.util.Scanner;

public class DisplayNumbersInPyramidPattern {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number to see a pyramid built upon that number: ");
		
		int userInput = input.nextInt();
		
		for(int i = 1; i <= userInput; i++) {
			for(int j = userInput; j > i; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k < i; k++) {
				System.out.print(k);
			}
			for(int m = i; m > 0; m--) {
				System.out.print(m);
				
			}
			
			
			System.out.println(" ");
			input.close();
		}
		
	}

}

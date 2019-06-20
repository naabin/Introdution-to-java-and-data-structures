package com.exercise;

import java.util.Scanner;

public class DisplayPyramid {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of lines: ");
		
		int numOfLines = input.nextInt();
		
		while(numOfLines > 0) {
			for(int i = numOfLines; i > 1; i--) {
				System.out.print(i + " ");
			}
			for(int j = 1; j <= numOfLines; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
			numOfLines--;
		}
		input.close();
		
	}

}

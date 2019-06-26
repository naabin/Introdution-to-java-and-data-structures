package com.exercise;

import java.util.Random;
import java.util.Scanner;

public class PrinMatrix {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = input.nextInt();
		printMatrix(n);
		input.close();
	}
	
	public static void printMatrix(int n) {
		for(int i = 1; i <= n; i++) {
			System.out.print((int)(new Random().nextInt(2)) + " ");
			for(int j = 1; j < n; j++) {
				System.out.print((new Random().nextInt(2)) + " ");
			}
			System.out.println();
		}
		
	}

}

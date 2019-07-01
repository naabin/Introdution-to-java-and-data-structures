package com.practice;

import java.util.Scanner;

public class InititalizeTwoDimensionalArrays {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int [][] matrix = new int[10][10];
		System.out.print("Enter " + matrix.length + " rows and "+ matrix[0].length + " columns: " );
		
		for(int row = 0; row < matrix.length; row++) {
			for(int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = input.nextInt();
				System.out.print(matrix[row][column]);
			}
			System.out.println();
		}
		input.close();
	}

}

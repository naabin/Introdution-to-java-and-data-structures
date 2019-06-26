package com.exercise;

import java.util.Scanner;

public class SortThreeNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three integers to sort them followed by space: ");
		double num1 = input.nextDouble();
		double num2 = input.nextDouble();
		double num3 = input.nextDouble();
		
		System.out.print("Sorted version of of entered version is ");
		displaySortedNumbers(num1, num2, num3);
		input.close();
	}
	public static void displaySortedNumbers(double num1, double num2, double num3) {
		if(num1 > num2) {
			double temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if(num2 > num3) {
			double temp = num2;
			num2 = num3;
			num3 = temp;
		}
		if(num3 > num1) {
			double temp = num3;
			num3 = num1;
			num1 = temp;
		}
		System.out.println(num1 + " " + num2 + " " + num3);
	}	
}

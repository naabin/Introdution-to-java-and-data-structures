package com.exercise;

import java.util.Scanner;

public class PiApproximationBySummation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number to approximate a π: ");
		int num = input.nextInt();
		System.out.println("i        m(i)");
		System.out.println("______________");
		printPiApproximation(num);
		input.close();
	}

	private static void printPiApproximation(int num) {

		double sum = 0;
		for (int i = 1; i <= num; i++) {

			sum += ((Math.pow((-1), i + 1)) / ((2.0 * i) - 1));
			double accumulatedPI = 4 * sum;

			System.out.println(i + "         " + accumulatedPI);
		}
	}

}

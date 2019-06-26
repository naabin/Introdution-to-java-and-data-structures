package com.exercise;

import java.util.Scanner;

public class SumSeries {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a nubmber to accumulate the sum serires: ");
		int num = input.nextInt();
		System.out.println("i           m(i)");
		System.out.println("___________________");
		printSumSeries(num);
		input.close();
	}
	public static void printSumSeries(int num) {
		double sum = 0;
		for(int i = 1; i <= num; i++) {
			sum += (i * 1.0)/(i + 2.0);
			System.out.println(i + "           " + sum);
		}
	}

}

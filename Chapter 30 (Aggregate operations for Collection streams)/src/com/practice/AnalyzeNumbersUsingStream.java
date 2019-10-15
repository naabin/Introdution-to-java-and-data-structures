package com.practice;

import java.util.Scanner;
import java.util.stream.DoubleStream;

public class AnalyzeNumbersUsingStream {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of items: ");
		try {
			int n = input.nextInt();
			double [] numbers = new double[n];
			
			System.out.print("Enter the numbers: ");
			
			for(int i = 0; i < n; i++) {
				numbers[i] = input.nextDouble();
				
			}
			
			double average = DoubleStream.of(numbers).average().getAsDouble();
			System.out.println("Average is " + average);
			System.out.println("Number of elements above the average is: "
					 + DoubleStream.of(numbers).filter(e -> e > average).count());
			
		} catch (Exception e) {
			System.out.println("Enter a  valid integer or decimal value");
		}
		
		input.close();
		
	}

}

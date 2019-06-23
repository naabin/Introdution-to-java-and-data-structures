package com.exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputeMeanAndDeviation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 numbers followed by space and end with semicolon: ");

		ArrayList<Double> nums = new ArrayList<Double>();
		
		while(input.hasNextDouble()) {
			nums.add(input.nextDouble());
		}
		
		double sum = 0;
		double deviationSum = 0;
		for(int i = 0; i < nums.size(); i++) {
			sum += nums.get(i);
			deviationSum += Math.pow(nums.get(i), 2);
		}
		double mean = sum/nums.size();
		double deviation = Math.sqrt((deviationSum - (Math.pow(sum, 2)/nums.size()))/nums.size()-1);
		System.out.println("The mean is " + mean);
		System.out.printf("The standard deviation is %.5f",  deviation);
		input.close();
	}

}

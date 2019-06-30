package com.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class AverageAnArray {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the length of an array: ");
		int arrayLength = input.nextInt();
		int [] nums = new int[arrayLength];
		System.out.print("Enter numbers: ");
		for(int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		}
		System.out.println("Average of an array " + Arrays.toString(nums) + " is " + average(nums));
		input.close();

	}
	
	public static int average(int[] array) {
		int tempSum = 0;
		int tempCount = 0;
		int sum = 0;
		for(int i = 0; i < array.length; i++) {
			tempCount += 1;
			tempSum += array[i];
		}
		sum = tempSum/tempCount;
		return sum;
	}
	public static double average(double[] array) {
		double count = 0;
		double sum = 0;
		for(int i = 0; i < array.length; i++) {
			count += 1;
			sum += array[i];
		}
		
		return (sum/count) * 1.0;
	}
}

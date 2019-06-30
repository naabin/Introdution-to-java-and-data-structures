package com.excercise;


import java.util.Scanner;

public class CountOccurence {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the lenght of the array: ");
		int arrayLength = input.nextInt();
		int [] nums = new int[arrayLength];
		System.out.print("Enter the array element of integer type: ");
		for(int i = 0; i < nums.length; i++) {
			nums[i] = input.nextInt();
		}
		
		int[] count = new int[100];
		for(int j = 0; j < nums.length; j++) {
			int temp = nums[j];
			count[temp]++;
		}
		for(int i = 1; i < count.length; i++) {
			if(count[i] == 1 && count[i] > 0) {
				System.out.println(i + " occurs " + count[i] + " time" );
			}
			else if(count[i] >= 2) {
				System.out.println(i + " occurs " + count[i] + " times" );
			}
		}

		input.close();
	}

}

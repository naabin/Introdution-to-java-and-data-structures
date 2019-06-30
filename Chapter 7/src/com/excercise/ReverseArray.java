package com.excercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the length of an array: ");
		int arrayLength = input.nextInt();
		int[]array = new int[arrayLength];
		System.out.print("Enter the array elements: ");
		for(int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();
		}
		System.out.println("The reverse array of an " + Arrays.toString(array) + " is " + Arrays.toString(reverse(array) ));
		
		input.close();

	}
	
	public static int[] reverse(int[] array) {
		int[] reversedArray = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			reversedArray[i] = array[(array.length-1)-i];
		}
		return reversedArray;
	}

}

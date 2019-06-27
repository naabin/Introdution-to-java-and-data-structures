
package com.practice;

import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the size of the array: ");
		int sizeOfTheArray = input.nextInt();
		
		int [] list = new int[sizeOfTheArray];
		System.out.print("Enter numbers followed by space: ");
		for(int i = 0; i < list.length; i++) {
			list[i] = input.nextInt();
		}
		System.out.println("Reversed Array is as follows: ");
		int[] reversedArray = reverse(list);
		System.out.print("[ ");
		for(int i = 0; i < reversedArray.length; i++) {
			System.out.print(reversedArray[i] + ", ");
		}
		System.out.print("]");
		System.out.println();
		input.close();
		
	}
	
	public static int[] reverse(int [] list) {
		int[] result = new int[list.length];
		for(int i = 0, j = result.length-1; i < list.length; i++, j--) {
			result[j] = list[i];
		}
		return result;
	}

}

package com.practice;

import java.util.Scanner;

public class LinearSearch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the linear search program");
		System.out.print("Enter the length of the array: ");
		int sizeOfTheArray = input.nextInt();
		int [] array = new int[sizeOfTheArray];
		System.out.print("Enter the elements of the array: ");
		for(int i = 0 ; i < array.length; i++) {
			array[i] = input.nextInt();
			
		}
		System.out.print("Enter a key to find an element: ");
		int key = input.nextInt();
		int linearSearch = linearSearch(array, key);
		
		if(linearSearch != -1) {
			System.out.println("The element you are looking for is at index " + linearSearch);
		}
		else {
			System.out.println("The element you are looking for could not be found: " + linearSearch);
			
		}
		input.close();
	}
	/**
	 * Implements the linear search
	 * @param list
	 * @param key
	 * @return the index of the found element otherwise returns -1
	 */
	public static int linearSearch(int[] list, int key) {
		for( int i = 0; i < list.length; i++) {
			if(key == list[i]) {
				return i;
			}
		}
		return -1;
	}

}

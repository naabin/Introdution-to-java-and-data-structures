package com.practice;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to binary search implementation: ");
		System.out.print("Enter the length of an array(array has to be sorted: ");
		int sizeOfAnArray = input.nextInt();
		int[] sortedArray = new int[sizeOfAnArray];
		
		System.out.print("Enter the array elements: ");
		for(int i = 0; i < sortedArray.length; i++) {
			sortedArray[i] = input.nextInt();
		}
		System.out.print("Now enter the key to find an index of the particular element: ");
		int key = input.nextInt();
		
		int binarySearch = binarySearch(sortedArray, key);
		
		if(binarySearch != -1) {
			System.out.println("Element you are looking is at index " + binarySearch);
		}
		else {
			System.out.println("Sorry could not find the element you  are looking for!");
			System.exit(1);
		}
		
		input.close();
		
	}
	
	/**
	 * Binary search implementation
	 * @param sortedArray
	 * @param key
	 * @return index of an array element if found other wise return -1
	 */
	public static int binarySearch(int [] sortedArray, int key) {
		int low = 0;
		int high = sortedArray.length;
		
		while(high >= low) {
			int mid = (high + low)/2;
			if(key == sortedArray[mid]){
				return mid;
			}
			else if(key > sortedArray[mid]) {
				low = mid + 1;
			}
			else {
				high = mid  - 1;
			}
			
		}
		return -low-1;
	}

}

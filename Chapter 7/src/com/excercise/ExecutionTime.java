package com.excercise;


import com.practice.BinarySearch;
import com.practice.LinearSearch;

public class ExecutionTime {

	public static void main(String[] args) {
		int[] array = new int[100000000];
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		long startTime = System.nanoTime();
		
		int linearSearch = LinearSearch.linearSearch(array, 99999999);
		System.out.println("Linear search algorithm for finding an element at: " + linearSearch);
		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;
		System.out.println("The execution time for the linear search is " + executionTime);
		
		long startTime2 = System.nanoTime();
		int binarySearch = BinarySearch.binarySearch(array, 99999999);
		System.out.println("Binary search algorithm for finding an element at: " + binarySearch);
		long endTime2 = System.nanoTime();
		long exectutionTime2 = endTime2 - startTime2;
		System.out.println("The execution time for the binary search is " + exectutionTime2);
		
//		System.out.println("Binary search is " + (executionTime - exectutionTime2) + " faster than linear search in nano seconds.");
		
		
	}

}

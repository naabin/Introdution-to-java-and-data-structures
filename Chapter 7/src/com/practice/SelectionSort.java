package com.practice;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arrays = { 2, 4, 6, 8, 9, 3, 1 };
		int[] sortedList = sortedList(arrays);
		System.out.print("[ ");
		for (Integer i : sortedList) {
			System.out.print(i +" ");
		}
		System.out.print("]");

	}

	public static int[] sortedList(int[] arrays) {
		int[] sortedArrays = arrays;
		
		for (int i = 0; i < arrays.length; i++) {
			int smallestElement = arrays[i];
			int currentMinIndex = i;
			
			for(int j = i+1; j < arrays.length; j++) {
				if(smallestElement > arrays[j]) {
					smallestElement = arrays[j];
					currentMinIndex = j;
				}
			}
			if(currentMinIndex != i) {
				sortedArrays[currentMinIndex] = sortedArrays[i];
				sortedArrays[i] = smallestElement;
			}
		}
		return sortedArrays;
	}

}

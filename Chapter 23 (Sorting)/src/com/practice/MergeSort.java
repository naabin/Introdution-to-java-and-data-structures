package com.practice;


import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Merge Sort");
		System.out.print("Enter the length of the array: ");
		try {
			int arrayLength = in.nextInt();
			int[] list = new int[arrayLength];
			
			for(int i = 0; i < list.length; i++) {
				System.out.print("Enter an element: ");
				list[i] = in.nextInt();
			}
			System.out.println("The unsorted array");
			System.out.println(Arrays.toString(list));
			System.out.println("The sorted array using sort method");
			MergeSort.mergeSort(list);
			System.out.println(Arrays.toString(list));
			
		}catch (NumberFormatException e) {
			System.out.println("Enter a valid number");
			e.printStackTrace();
		}
		in.close();
	}
	
	public static void mergeSort(int[] list) {
		
		if(list.length > 1) {
			//Merge sort the first half
			int[] firstHalf = new int[list.length/2];
			System.arraycopy(list, 0, firstHalf, 0, list.length/2);
			mergeSort(firstHalf);
			
			//Merge sort the second half
			int secondHalfLength = list.length - list.length/2;
			int[] secondHalf = new int[secondHalfLength];
			System.arraycopy(list, list.length/2, secondHalf, 0, secondHalfLength);
			mergeSort(secondHalf);
			
			//Merge first half with second half into the list
			merge(firstHalf, secondHalf, list);
		}
	}
	
	public static void merge(int[] list1, int[] list2, int[] temp) {
		int current1 = 0;
		int current2 = 0;
		int current3 = 0;
		
		while(current1 < list1.length && current2 < list2.length) {
			if(list1[current1] < list2[current2]) {
				temp[current3++] = list1[current1++];
			}
			else {
				temp[current3++] = list2[current2++];
			}
		}
		while(current1 < list1.length) {
			temp[current3++] = list1[current1++];
		}
		while(current2 < list2.length) {
			temp[current3++] = list2[current2++];
		}
	}

}

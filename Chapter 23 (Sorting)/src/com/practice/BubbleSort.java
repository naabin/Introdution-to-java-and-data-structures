package com.practice;

import java.util.Scanner;

public class BubbleSort {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to Bubble Sort: ");
		System.out.print("Enter the length of an array: ");
		int arrayLength  = in.nextInt();
		int [] list = new int[arrayLength];
		for(int i = 0; i < list.length; i++) {
			System.out.print("Enter an element: ");
			list[i] = in.nextInt();
		}
		System.out.print("The array you have enetered is ");
		for(Integer i: list) {
			System.out.print(i + " ");
		}
		System.out.println();
		BubbleSort.bubbleSort(list);
		System.out.print("Array sorted using bubble sort method: ");
		for(Integer i: list) {
			System.out.print(i + " ");
		}
		in.close();
		
		
	}
	
	public static void bubbleSort(int[] list) {
		boolean needNextPass = true;
		for(int k = 1; k < list.length && needNextPass; k++) {
			needNextPass = false;
			for(int i = 0; i < list.length - k; i++) {
				if(list[i] > list[i + 1]) {
					int temp = list[i];
					list[i] = list[i + 1];
					list[i + 1] = temp;
					
					needNextPass = true;
				}
			}
		}
	}

}

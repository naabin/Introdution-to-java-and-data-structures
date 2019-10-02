package com.practice;

import java.util.Scanner;

public class InsertionSort {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to insertion sort.");
		System.out.print("Enter the length of an array: ");
		int arryaLength = in.nextInt();
		int [] list = new int[arryaLength];
		
		for(int i = 0; i < list.length; i++) {
			System.out.print("Enter an element: ");
			list[i] = in.nextInt();
		}
		System.out.println("The list you've given is ");
		for(Integer i: list) {
			System.out.print(i + " ");
		}
		System.out.println();
		insertionSort(list);
		
		in.close();
		
	}
	
	public static void insertionSort(int[] list) {
		for(int i = 1; i < list.length; i++) {
			int currentElement = list[i];
			int k;
			for(k = i-1; k >= 0 && list[k] > currentElement; k--) {
				list[k + 1] = list[k];
			}
			list[k + 1] = currentElement;
		}
		
		System.out.println("Sorted list using insertion sort");
		for(Integer i: list) {
			System.out.print(i + " ");
		}
		
	}

}

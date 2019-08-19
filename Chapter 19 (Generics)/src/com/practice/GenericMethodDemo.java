package com.practice;

public class GenericMethodDemo {
	
	public static <E> void print(E[] list) {
		for(E e: list) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Integer[] integers = {1, 2, 3, 4, 5, 6};
		String [] strings = {"London", "Paris", "New York", "Austin"};
		
		GenericMethodDemo.print(integers);
		GenericMethodDemo.print(strings);
	}
}

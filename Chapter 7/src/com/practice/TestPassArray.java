package com.practice;

public class TestPassArray {

	public static void main(String[] args) {
		
		int [] a = {1 ,2};
		
		//Swap elements using the swap method
		System.out.println("Before invoking the swap");
		System.out.println(" array is {"+ a[0] + ", " + a[1] + "}" );
		swap(a[0], a[1]);
		System.out.println("After invoking swap");
		System.out.println(" array is {"+ a[0] + ", " + a[1] + "}" );
		
		//Swap elements using the swapFirstToInArray
		System.out.println("Before invoking swapFirstTwoInArray");
		System.out.println(" array is {"+ a[0] + ", " + a[1] + "}" );
		swapFirstTwoInArray(a);
		
		System.out.println("After invoking swapFirstTwoInArray");
		System.out.println(" array is {"+ a[0] + ", " + a[1] + "}" );
	}

	private static void swapFirstTwoInArray(int[] a) {
		
		int temp = a[0];
		a[0] = a[1];
		a[1] = temp;
		
	}

	private static void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;
		
	}

}

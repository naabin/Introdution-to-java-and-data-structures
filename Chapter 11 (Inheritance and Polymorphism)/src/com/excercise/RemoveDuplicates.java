package com.excercise;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 10 integers: ");
		
		ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
		int value;
		do {
			value = input.nextInt();
			if(!listOfIntegers.contains(value)) {
				listOfIntegers.add(value);
			}
		}
		while(value != 0);
		
		System.out.println(listOfIntegers.toString());
		input.close();
	}
	

}

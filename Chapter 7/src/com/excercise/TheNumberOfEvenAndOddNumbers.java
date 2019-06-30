package com.excercise;


import java.util.Scanner;

/**
 * 
 * @author nabin
 * program that reads integers and then display
 * the number of even and odd numbers.
 * assume that the input ends with 0
 */
public class TheNumberOfEvenAndOddNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the length of an array:");
		int arrayLength = input.nextInt();
		int [] numbers = new int[arrayLength];
		System.out.print("Enter numbers: ");
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
			
			if(numbers[i] == 0) {
				break;
			}
			
		}
		int evenCount = 0;
		int oddCount = 0;
		
		for(int i =0; i < numbers.length; i++) {
			if(numbers[i] % 2 == 0) {
				evenCount += 1;
			}
			else {
				oddCount += 1;
			}
		}
		System.out.println("The number of odd numbers are: " + oddCount);
		System.out.println("Then number of even numbers are: " + evenCount);
		input.close();
	}

}

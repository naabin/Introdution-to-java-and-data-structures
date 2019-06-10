package com.exercise;

import java.util.Scanner;

public class IsbnTen {

	public static void main(String[] args) {
		System.out.print("Enter the first 9 digits of an ISBN as integer: ");
		Scanner input = new Scanner(System.in);
		
		int nineIsbn = input.nextInt();
		int[] splitIsbn = new int[10];
		
		for(int i = 0 ; i <= nineIsbn; i++) {
			splitIsbn[0] = 0;
			splitIsbn[1] = 1;
			splitIsbn[8-i] = nineIsbn % 10;
			
			nineIsbn = nineIsbn / 10;
		}
		int tenthIsbn = 0;
		for(int i = 0; i < splitIsbn.length; i++) {
			tenthIsbn += (splitIsbn[i] * (i+ 1));	
		}
		int tenth = tenthIsbn % 11;
		
		if(tenthIsbn == 10) {
			splitIsbn[9] = 'X';

		}
		else {
			splitIsbn[9] = tenth;
		}
		System.out.print("The ISBN-10 number is ");
		for(Object i: splitIsbn) {
			System.out.print(i);
		}
		
		input.close();
		
	}

}

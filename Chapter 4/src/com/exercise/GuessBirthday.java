package com.exercise;

import java.util.Scanner;

public class GuessBirthday {

	public static void main(String[] args) {

		String set1 = 
				"1 3 5 7\n"
				+ "9 11 13 15\n"
				+ "17 19 21 23\n"
				+ "25 27 29 31";
		
		String set2 = 
				"2 3 6 7\n"
				+ "10 11 14 15\n"
				+ "18 19 22 23\n"
				+ "26 27 30 31";
		
		String set3 = 
				"4 5 6 7\n"
				+ "12 13 14 15\n"
				+ "20 21 22 23\n"
				+ "28 29 30 31";
		
		String set4 = 
				"8 9 10 11\n"
				+ "12 13 14 15\n"
				+ "24 25 26 27\n"
				+ "28 29 30 31";
		
		String set5 = 
				"16 17 18 19\n"
				+ "20 21 22 23\n"
				+ "24 25 26 27\n"
				+ "28 29 30 31";
		
		int day = 0;
		
		String [] listOfDay = {set1, set2, set3, set4, set5};
		Scanner input = new Scanner(System.in);
		for(int i = 0; i < listOfDay.length; i++) {
			System.out.print("Is your birthday in set\n" + listOfDay[i] + "\n");
			System.out.print("Print Y for yes and N for No: ");
			String answer = input.next();
			if(answer.toUpperCase().charAt(0) == 'Y') {
				day += Math.pow(2, i);
				System.out.println();
			}
			else {
				System.out.println();
				continue;
			}
		}
		System.out.println("Your birthday is in " + day + "!");
		input.close();
		
	}

}

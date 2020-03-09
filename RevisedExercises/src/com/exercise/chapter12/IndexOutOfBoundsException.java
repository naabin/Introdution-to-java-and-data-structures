package com.exercise.chapter12;

import java.util.Scanner;

public class IndexOutOfBoundsException {

	public static void main(String[] args) {
		String[] months = { "January", "February", "March", "April","May", "June", "July", "August", "September", "October",
				"November", "December" };

		int[] dom = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 1 and 12: ");

		while (true) {
			try {
				int num = input.nextInt();
				System.out.println("You choose for " + months[num - 1] + " and it has " + dom[num - 1] + " days");
				input.close();
				break;
				
			} catch (ArrayIndexOutOfBoundsException exception) {
				System.out.println("You can only enter a value between 1 and 12");
			}
			continue;
		}

	}

}

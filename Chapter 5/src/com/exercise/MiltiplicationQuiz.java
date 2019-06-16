package com.exercise;

import java.util.Scanner;

public class MiltiplicationQuiz {

	public static void main(String[] args) {
		final int NUMBER_OF_QUESTIONS = 5;
		int correctResult = 0;
		int count = 0;
		
		long startTime = System.currentTimeMillis();
		
		String output= "";
		
		Scanner input = new Scanner(System.in);
		
		while(count < NUMBER_OF_QUESTIONS) {
			int number1 = (int)(Math.random() * 13);
			int number2 = (int)(Math.random() * 13);
			
			System.out.print("What is " + number1 + " * " + number2 + "? ");
			int answer = input.nextInt();
			
			if(number1 * number2 == answer) {
				System.out.println("\nYou are correct");
				correctResult++;
			}
			else {
				System.out.println("\nYour answer is wrong.\nTHe correct answer is " + number1 * number2 );
				
			}
			count++;
			output += "\n" + number1  + " * " + number2  +" = " + answer + ((number1 * number2 == answer) ? " correct" : " wrong");
			
			long endTime = System.currentTimeMillis();
			long testTime = endTime - startTime;
			
			System.out.println("You got " + correctResult+ " correct  out of " + NUMBER_OF_QUESTIONS + " questions\n"
					+ "it took " + testTime/1000 + " seconds to complete the quiz " + output);
			
			
		}
		input.close();
		
	}

}

package com.excercise;

import java.util.Scanner;

public class AssignGrades {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int numOfStuents = input.nextInt();
		
		int[]scores = new int[numOfStuents];
		
		System.out.print("Enter " + numOfStuents + " scores: ");
		for(int i = 0; i < scores.length; i++) {
			scores[i] = input.nextInt();
		}
		int max = 0;
		for(int i = 0; i < scores.length; i++) {
			if(max < scores[i]) {
				max = scores[i];
			}
		}
		for(int i = 0; i < scores.length; i++) {
			char grade = 0;
			if(scores[i] >= max-5) {
				grade = 'A';
			}
			else if(scores[i] >= max-10) {
				grade = 'B';
			}
			else if(scores[i] >= max-15) {
				grade = 'C';
			}
			else if(scores[i] >= max-20) {
				grade = 'D';
			}
			else {
				grade = 'F';
			}
			
			System.out.println("Student " + i + " score is " + scores[i] + " and grade is "+ grade);
		}
		
		input.close();
	}

}

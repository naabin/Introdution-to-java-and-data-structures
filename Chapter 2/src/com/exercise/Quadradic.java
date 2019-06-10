package com.exercise;

import java.util.Scanner;

public class Quadradic {

	/*
	 * Algebra: solve qudratic equations. THe two roots of a quadratic equation ax^2
	 * + bx + c = 0 can be obtained using the following formula
	 * 
	 */

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the coeffiecients a, b and c respectively:");
		double a = input.nextDouble();
		System.out.print("b:");
		double b = input.nextDouble();
		System.out.print("c:");
		double c = input.nextDouble();
		
		String result = "";
		
		double discriminant = Math.pow(b, 2) - 4 * a * c;
		
		if(discriminant > 0){
			double result1 = (-b + Math.sqrt(discriminant))/2 * a;
			double result2 = (-b - Math.sqrt(discriminant))/2 * a;
			result = "The equation has two real roots and they are: " + result1 + ", " + result2; 
		}
		
		else if(discriminant == 0) {
			double r = (-b + Math.sqrt(discriminant))/ 2 * a;
			result = "The equation has one real roots and it is: " + r;
		}
		else {
			result = "The equation has no real roots";
		}
		System.out.println(result);
		input.close();
		
	}

}

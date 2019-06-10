package com.practice;

import java.util.Scanner;

public class ComputeAngles {

	public static void main(String[] args) {
		System.out.println("Enter three points");
		Scanner input = new  Scanner(System.in);
		System.out.print("Enter x1: ");
		double x1 = input.nextDouble();
		System.out.print("Enter y1: ");
		double y1 = input.nextDouble();
		System.out.print("Enter x2: ");
		double x2 = input.nextDouble();
		System.out.print("Enter y2: ");
		double y2 = input.nextDouble();
		System.out.print("Enter x3: ");
		double x3 = input.nextDouble();
		System.out.print("Enter y3: ");
		double y3 = input.nextDouble();
		
		//Compute three sides
		double a = Math.sqrt(Math.pow((x2-x3), 2) + Math.pow((y2-y3), 2));
		double b = Math.sqrt(Math.pow((x1-x3), 2) + Math.pow((y1-y3), 2));
		double c = Math.sqrt(Math.pow((x1-x2), 2) + Math.pow((y1-y2), 2));
		
		
		//Compute three angles
		double A = Math.toDegrees(Math.acos((Math.pow(a, 2) - Math.pow(b, 2) - Math.pow(c, 2))/(-2 * b * c)));
		double B = Math.toDegrees(Math.acos((Math.pow(b, 2) - Math.pow(a, 2) - Math.pow(c, 2))/(- 2 * b * c)));
		double C = Math.toDegrees(Math.acos((Math.pow(c, 2) - Math.pow(b, 2) - Math.pow(a, 2))/ (- 2 * a * b)));
		
		//Display results
		System.out.println("The three angles are " + Math.round(A * 100)/ 100.0 + " " + Math.round(B*100)/100.0 + " " + Math.round(C*100)/100.0);
		
		input.close();
	}

}

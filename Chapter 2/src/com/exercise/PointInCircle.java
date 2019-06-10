package com.exercise;

import java.util.Scanner;

public class PointInCircle {

	public static void main(String[] args) {

		System.out.print("Enter a point with two coordinates x1: : ");
		Scanner input = new Scanner(System.in);
		double x1 = input.nextDouble();
		System.out.print("Enter a second point y1: ");
		double y1 = input.nextDouble();
		
		double distance = Math.sqrt(Math.pow((x1 - 0), 2) + Math.pow((y1-0), 2));
		
		if(distance <= 10) {
			System.out.println("Point (" + x1 + ", " + y1 + ") is in the circle");
		}
		else {
			System.out.println("Point (" + x1 + ", " + y1 + ") is not in the circle");
		}
		
		input.close();
	}

}

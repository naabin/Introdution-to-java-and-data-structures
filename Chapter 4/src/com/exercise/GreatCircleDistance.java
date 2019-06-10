package com.exercise;

import java.util.Scanner;

public class GreatCircleDistance {
	private static final double EARTH_RADIUS = 6371.01;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter point 1 (lattitue and longitude ) in degrees: ");
		
		double x1 = Math.toRadians(input.nextDouble());
		double y1 = Math.toRadians(input.nextDouble());
		
		System.out.print("Enter point 2 (lattitude and longitude) in degrees: ");
		
		double x2 = Math.toRadians(input.nextDouble());
		double y2 = Math.toRadians(input.nextDouble());
		
		//Compute distance
		double distance = EARTH_RADIUS * Math.acos((Math.sin(x1) * Math.sin(x2)) + (Math.cos(x1) * Math.cos(x2)) * (Math.cos(y1 - y2)));
		
		System.out.println("The distance between the two points is " + distance + " km");
		
		input.close();
		
		
	}

}

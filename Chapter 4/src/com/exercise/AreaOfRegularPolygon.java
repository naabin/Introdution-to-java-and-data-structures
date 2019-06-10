package com.exercise;

import java.util.Scanner;

public class AreaOfRegularPolygon {
	/*
	 * A regular polygon is an n-sided polygon in which all sides are of the same
	 * length  and all angles have the same length and all angels have the same degree
	 * (i.e., the polygon is both equilateral and equiangular. 
	 */

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of sides: ");
		double n = input.nextDouble();
		System.out.print("Enter the side length: ");
		double s = input.nextDouble();
		
		double area = (n * Math.pow(s, 2)) / (4 * Math.tan(Math.PI/n));
		
		System.out.println("The area of the polygon is " + area);
		
		input.close();
	}

}

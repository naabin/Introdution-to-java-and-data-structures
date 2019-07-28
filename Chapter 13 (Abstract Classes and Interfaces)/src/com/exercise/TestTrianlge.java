package com.exercise;

import java.util.Scanner;

import com.practice.GeometricObject;

public class TestTrianlge {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 3 sides of the triangle: ");
		double side1 = input.nextDouble();
		double side2 = input.nextDouble();
		double side3 = input.nextDouble();
		
		System.out.print("Enter the color of a triangle: ");
		String color = input.next();
		System.out.print("Is the trianlge filled: ");
		boolean filled = input.nextBoolean();
		
		GeometricObject triangle = new Triangle(side1, side2, side3);
		triangle.setColor(color);
		triangle.setFilled(filled);
		
		System.out.println(triangle);
		System.out.println("Area of a triangle with given sides is " + triangle.getArea());
		System.out.println("Perimeter of a triangle with given sides is " + triangle.getPerimeter());
		
		input.close();
	}

}

package com.exercise;

import java.util.Scanner;

public class AreaOfPentagon {

	public static void main(String[] args) {
		Scanner input = new  Scanner(System.in);
		System.out.print("Enter the length from a pentagon to a vertex: ");
		double r = input.nextDouble();
		
		//compute length of a side 
		double side = (2 * r) * Math.sin(Math.PI/5);
		
		//compute the area of a pentagon
		
		double area = (5 * Math.pow(side, 2))/(4 * Math.tan(Math.PI/5));
		
		System.out.println("The area of the pentagon is: "+ area);
		
		input.close();
		
	}

}

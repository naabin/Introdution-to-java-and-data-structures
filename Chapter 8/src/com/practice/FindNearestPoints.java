package com.practice;

import java.util.Scanner;

public class FindNearestPoints {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of points: ");
		int numberOfPoints = input.nextInt();
		
		//create an array
		double[][] points = new double[numberOfPoints][2];
		System.out.print("Enter " + numberOfPoints + " points: ");
		for(int i = 0; i < points.length; i++) {
			points[i][0] = input.nextDouble();
			points[i][1] = input.nextDouble();
		}
		//p1 and p2 are the indices in the points array
		int p1 = 0, p2 = 1;
		double shortestDistance = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]);
		
		//compute distance for every two points
		for(int i = 0; i < points.length; i++) {
			for(int j = i+1; j < points.length; j++) {
				double distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]);//find distance
				
				if(shortestDistance > distance) {
					p1 = i;//update p1
					p2 = j;//update p2
					shortestDistance = distance;
					
				}
			}
			
		}
		System.out.println("The closest two points are " + "(" + points[p1][0] + ", " + points[p1][1] + ") and ("
				+ points[p2][0] + ", " + points[p2][1] + ")");
		input.close();
	}

	private static double distance(double x1, double y1, double x2, double y2) {
		
		return Math.sqrt(Math.pow((x2-x1), 2) + Math.pow(y2-y1, 2));
	}

}

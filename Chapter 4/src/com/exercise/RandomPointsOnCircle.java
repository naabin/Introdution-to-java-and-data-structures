package com.exercise;

public class RandomPointsOnCircle {
	
	/*
	 * Write a program that generates three random points
	 * that forms a triangle and 
	 * formed by these three points
	 */
	

	public static void main(String[] args) {
		
		int radius = 40;
		
		int x1 =  (int) (radius * Math.cos(Math.random() * (2 * Math.PI)));
		int y1 =  (int) (radius * Math.sin(Math.random() * (2 * Math.PI)));
		
		
		int x2 = (int) (radius * Math.cos(Math.random() * (2 * Math.PI)));
		int y2 = (int) (radius * Math.sin(Math.random() * (2 * Math.PI)));
		
		int x3 = (int) (radius * Math.cos(Math.random() * (2 * Math.PI)));
		int y3 = (int) (radius * Math.sin(Math.random() * (2 * Math.PI)));
		
		
		System.out.println("First random point on the circle : (" + x1 + ", " + y1+ ")");
		System.out.println("Second random point on the circle : (" + x2 + ", " + y2 + ")");
		System.out.println("Third random point on the circle : (" + x3 + ", " + y3 + ")");
		
	}

}

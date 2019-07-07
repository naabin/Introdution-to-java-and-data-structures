package com.practice;

public class Circle {
	
	private double radius;
	
	public Circle() {
		radius = 1;
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	double getPerimiter() {
		return 2 * radius * Math.PI;
	}
	
	public static void main(String[] args) {
		Circle circle = new Circle();
		System.out.println(circle.radius);
	}
	
}

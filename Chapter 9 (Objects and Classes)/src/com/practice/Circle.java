package com.practice;

public class Circle {
	
	double radius;
	
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
	
}

package com.practice;

public class Circle extends GeometricObject {
	private double radius;
	
	public Circle() {

	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
		
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI * (Math.pow(radius, 2));
	}
	
	public double getDiameter() {
		return 2 * radius;
	}
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	public void printCircle() {
		System.out.println("The circle is created at " + getDateCreated() + " and the radius is " + radius );
	}
	
}

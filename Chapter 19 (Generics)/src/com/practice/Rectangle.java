package com.practice;

public class Rectangle extends GeometricObject {
	
	private double length;
	private double width;
	
	public Rectangle() {
		super();
		length = 1;
		length = 1;
	}
	
	public Rectangle(double length, double width, String color, boolean filled) {
		super(color, filled);
		this.length = length;
		this.width = width;
	}
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public double getPerimeter() {
		return (2 * length) + (2 * width);
	}

	@Override
	public String getClassName() {
		return "Rectangle";
	}

}

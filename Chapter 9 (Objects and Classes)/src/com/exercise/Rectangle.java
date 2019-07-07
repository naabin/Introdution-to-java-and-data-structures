package com.exercise;

public class Rectangle {
	
	private double width;
	private double height;
	
	public Rectangle() {
		width = 1;
		height = 1;
	}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
		
	}
	
	public double getWidth() {
		return width; 
	}
	public void setWidth(double width) {
		if(width >= 0) {
			this.width = width;
		}
		else {
			System.out.println("Width cannot be negative.");
			System.exit(1);
		}
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		if(height >= 0) {
			this.height = height;
		}
		else {
			System.out.println("Height cannot be negative.");
			System.exit(1);
		}
	}
	public double getArea() {
		return height * width;
	}
	public double getPerimeter() {
		return (2 * height) + (2 * width);
	}
	
	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle(4, 40);
		Rectangle rectangle2 = new Rectangle(3.5, 35.9);
		System.out.println("The area of Rectangle 1 with width: " + rectangle1.getWidth() + " and height: " + rectangle1.getHeight()+
				" area is: " + rectangle1.getArea() + " and it's perimeter is: " + rectangle1.getPerimeter());
		
		System.out.println();
		System.out.println("The area of Rectangle 2 with width: " + rectangle2.getWidth() + " and height: "+ rectangle2.getHeight() +
				" area is: " + rectangle2.getArea() + " and it's perimeter is: " + rectangle2.getPerimeter());
	}
}

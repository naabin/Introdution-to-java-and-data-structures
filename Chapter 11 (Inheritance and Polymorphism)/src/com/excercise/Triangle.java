package com.excercise;

import com.practice.GeometricObject;

public class Triangle extends GeometricObject {
	
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle() {
		super();
		side1 = 1;
		side2 = 1;
		side3 = 1;
	}
	
	public Triangle(double side1, double side2, double side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public double getSide1() {
		return side1;
	}

	public double getSide2() {
		return side2;
	}

	public double getSide3() {
		return side3;
	}
	
	public double getArea() {
		double s = (side1 + side2 + side3)/2;
		double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		return area;
	}
	
	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	@Override
	public String toString() {
		return super.toString() +  "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "]";
	}
	
	public static void main(String[] args) {
		Triangle triangle1 = new Triangle(2, 3, 5);
		triangle1.setColor("Blue");
		System.out.println(triangle1);
	}
}

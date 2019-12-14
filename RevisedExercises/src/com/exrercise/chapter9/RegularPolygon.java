package com.exrercise.chapter9;

public class RegularPolygon {

	// Number of sides of polygon
	private int n;
	// Length of the side of a plygon
	private double side;
	// X co-ordinate
	private double x;

	// y co-ordinate
	private double y;

	public RegularPolygon() {
		this(3, 1, 0, 0);
	}

	public RegularPolygon(int numberOfSides, int lengthOfSide) {
		this.n = numberOfSides;
		this.side = lengthOfSide;
		this.x = 0;
		this.y = 0;
	}

	public RegularPolygon(int n, double side, double x, double y) {
		this.n = n;
		this.side = side;
		this.x = x;
		this.y = y;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getPerimeter() {
		return this.n * this.side;
	}

	public double getArea() {
		double area = (this.n * Math.pow(this.side, 2))/(4 * Math.tan(Math.PI/this.n));
		return area;
	}
	
	public static void main(String[] args) {
		RegularPolygon regularPolygon = new RegularPolygon(6, 4);
		RegularPolygon regularPolygon2 = new RegularPolygon(10, 4, 5.6, 7.8);
		
		System.out.println(regularPolygon.getPerimeter());
		System.out.println(regularPolygon.getArea());
		System.out.println("************************");
		System.out.println(regularPolygon2.getPerimeter());
		System.out.println(regularPolygon2.getArea());
	}
}

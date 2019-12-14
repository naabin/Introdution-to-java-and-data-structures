package com.exrercise.chapter9;

public class QuadraticEquation {

	private int a, b, c;

	public QuadraticEquation(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	public double getDiscriminant() {
		return Math.pow(b, 2) - 4 * a * c;
	}

	public double root1() {
		double root = 0;
		if (getDiscriminant() < 0) {
			return root;
		}
		root = (-b + Math.sqrt(getDiscriminant())) / 2 * a;
		return root;
	}

	public double root2() {
		double root = 0;
		if (getDiscriminant() < 0) {
			return root;
		}
		root = (-b - Math.sqrt(getDiscriminant())) / 2 * a;
		return root;
	}
	
	public static void main(String[] args) {
		QuadraticEquation quadraticEquation = new QuadraticEquation(1, 20, 2);
		
		System.out.println("Root 1: " + quadraticEquation.root1());
		System.out.println("Root 2: " + quadraticEquation.root2());
		
	}
}

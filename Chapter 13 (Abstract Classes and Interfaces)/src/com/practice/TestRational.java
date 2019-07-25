package com.practice;

public class TestRational {
	
	public static void main(String[] args) {
		Rational r1 = new Rational(100, 200);
		
		Rational r2 = new Rational(5, 3);
		
		
		System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
		
		System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
		
		System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
		
		System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
	}
}

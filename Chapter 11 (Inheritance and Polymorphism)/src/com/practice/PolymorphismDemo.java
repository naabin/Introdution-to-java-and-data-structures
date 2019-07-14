package com.practice;
/**
 * 
 * @author nabin
 * An object of a subclass can be used wherever its superclass object is used.
 * This is commonly known as polymorphism.
 */
public class PolymorphismDemo {

	public static void main(String[] args) {
		displayObject(new Circle(1, "red", true)); // polymorphic call
		displayObject(new Rectangle(1, 1, "black", true)); // polymorohic call
	}
	
	public static  void displayObject(GeometricObject object) {
		System.out.println("Created on: " + object.getDateCreated() + ". Color is " + object.getColor());
	}

}

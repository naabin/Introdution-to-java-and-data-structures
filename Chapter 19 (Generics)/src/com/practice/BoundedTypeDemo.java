package com.practice;

public class BoundedTypeDemo {

	public static <E extends GeometricObject> boolean equalArea(E object1, E object2) {
		return object1.getArea() == object2.getArea();
	}
	
	
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(2, 2);
		Circle circle = new Circle(2, "Blue", false);
		
		System.out.println("Same area? " + equalArea(rectangle, circle));
	}
}

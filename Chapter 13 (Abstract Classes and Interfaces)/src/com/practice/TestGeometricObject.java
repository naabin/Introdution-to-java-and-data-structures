package com.practice;

public class TestGeometricObject {

	public static void main(String[] args) {
		GeometricObject geoObject = new Circle(5, "red", true);
		
		GeometricObject geoObject2 = new Rectangle(5, 3, "white", false);
		
		System.out.println("The two objects have the same area? " + equalArea(geoObject, geoObject2));
		
		displayGeometricObject(geoObject);
		
		displayGeometricObject(geoObject2);
	}

	private static void displayGeometricObject(GeometricObject object) {
		System.out.println();
		System.out.println("The area of " + object.getClassName() +" is " + object.getArea());
		System.out.println("The perimeter is "+ object.getClassName() + " is " + object.getPerimeter());
	}

	private static boolean equalArea(GeometricObject object, GeometricObject object2) {
		
		return object.getArea() == object2.getArea() ;
	}

}

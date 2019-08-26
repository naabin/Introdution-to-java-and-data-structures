package com.practice;

public class TestComparator {
	
	public static void main(String[] args) {
		GeometricObject g1 = new Rectangle(5, 5);
		GeometricObject g2 = new Circle(5, null, false);
		
		GeometricObject g = max(g1, g2, new GeometricObjectComparator());
		
		System.out.println("The area of the larger object is " + g.getArea());
		
	}

	private static GeometricObject max(GeometricObject g1, GeometricObject g2,
			GeometricObjectComparator geometricObjectComparator) {
		
		if(geometricObjectComparator.compare(g1, g2) > 0) {
			return g1;
		}
		else {
			return g2;
		}
	}

}

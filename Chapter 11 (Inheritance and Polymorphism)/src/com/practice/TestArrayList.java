package com.practice;

import java.util.ArrayList;

public class TestArrayList {
	public static void main(String[] args) {
		ArrayList<String> cityList = new ArrayList<String>();
		
		cityList.add("London");
		cityList.add("Denver");
		cityList.add("Paris");
		cityList.add("Miami");
		cityList.add("Seoul");
		cityList.add("Tokyo");
		
		
		System.out.println("List size? " + cityList.size());
		System.out.println("Is Miami in the list? " + cityList.contains("Miami"));
		System.out.println("The location of Denver in the list? " + cityList.indexOf("Denver"));
		System.out.println("Is the list empty? " + cityList.isEmpty());
		

		cityList.add(2, "Xian");
		cityList.remove("Miami");
		cityList.remove(1);
		
		System.out.println(cityList.toString());
		
		//Create a list to store two circles
		ArrayList<Circle> list = new ArrayList<Circle>();
		list.add(new Circle(1));
		list.add(new Circle(2));
		
		for(Circle circle: list) {
			System.out.println("The area of a circle "+ circle + " " +circle.getArea());
		}
	}
}

package com.practice;

public class SortRectanlges {

	public static void main(String[] args) {
		ComparableRectangle [] recatangles = {
				new ComparableRectangle(3.4, 5.4),
				new ComparableRectangle(13.4, 55.5),
				new ComparableRectangle(7.4, 35.4),
				new ComparableRectangle(1.4, 25.4),
		};
		
		for(Rectangle rectangle: recatangles) {
			System.out.println(rectangle + " ");
		}
	}

}

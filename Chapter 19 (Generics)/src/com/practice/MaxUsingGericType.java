package com.practice;

public class MaxUsingGericType {
	
	
	public static <E extends Comparable<E>> E max(E o1, E o2) {
		if(o1.compareTo(o2) > 0) {
			return o1;
		}
		else {
			return o2;
		}
	}

	public static void main(String[] args) {
		String string = "John";
		String string2 = "Doe";
		
		String max = MaxUsingGericType.max(string, string2);
		
		Integer num1 = 12;
		Integer num2 = 13;
		
		Integer max2 = MaxUsingGericType.max(num1, num2);
		
		System.out.println(max + " " + max2);
	}
}
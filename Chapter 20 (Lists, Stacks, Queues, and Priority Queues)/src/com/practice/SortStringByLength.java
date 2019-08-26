package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortStringByLength {
	
	public static void main(String[] args) {
		String[] cities = {"Atlanta", "Savannah", "New York", "Dallas"};
		Arrays.sort(cities, (s1, s2) -> {return s1.length() - s2.length();});
		
		for(String s: cities) {
			System.out.print(s + " ");
		}
		System.out.println();
		System.out.println("***********************");
		List<String> cities2 = Arrays.asList("Atlanta", "Savannah", "New York", "Dallas");
		
//		cities2.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
		//Or
		cities2.sort(String::compareToIgnoreCase);
		
		for(String s: cities2) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	public static class MyComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			
			return o1.length() - o2.length();
		}
		
	}

}

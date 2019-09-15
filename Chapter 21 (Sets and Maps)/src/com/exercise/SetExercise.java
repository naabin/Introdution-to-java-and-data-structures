package com.exercise;


import java.util.HashSet;
import java.util.Set;

public class SetExercise {
	
	public static void main(String[] args) {
		
		Set<String> course1 = new HashSet<>();
		course1.add("Chemistry");
		course1.add("Mathematics");
		course1.add("Biology");
		course1.add("English");
		
		Set<String> course2 = new HashSet<>();
		course2.add("Biology");
		course2.add("English");
		course2.add("Geography");
		course2.add("Physics");
		
		Set<String> course1Copy = new HashSet<String>(course1);
		Set<String> course2copy = new HashSet<String>(course2);
		
		course1.removeAll(course2);
		System.out.println("Only present in the first set " + course1);
		
		course2.removeAll(course1Copy);
		System.out.println("Only present in the second set " + course2);
		
		course2copy.retainAll(course1Copy);
		System.out.println("Present in the both set " + course2copy);
	}

}

package com.practice;

import java.util.LinkedHashSet;
import java.util.Set;

public class TestLinkedHashSet {
	
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
		
		set.add("London");
		set.add("Paris");
		set.add("New York");
		set.add("San Fransisco");
		set.add("Beijing");
		set.add("New York");
		
		System.out.println(set);
		
		set.forEach(e -> System.out.println(e.toLowerCase()));
		
	}

}

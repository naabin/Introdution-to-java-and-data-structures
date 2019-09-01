package com.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class TestIterator {
	
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList<String>();
		collection.add("New York");
		collection.add("Atlanta");
		collection.add("Dallas");
		collection.add("Madison");
		
		Iterator<String> iterator = collection.iterator();
		while(iterator.hasNext()) {
			System.out.print(iterator.next().toUpperCase() + " ");
		}
		System.out.println();
		
		//Using forEach
		collection.forEach(t -> System.out.print(t.toUpperCase() + " "));
	}

}
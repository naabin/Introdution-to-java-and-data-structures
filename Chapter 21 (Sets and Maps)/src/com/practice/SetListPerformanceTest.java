package com.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class SetListPerformanceTest {
	static final int N = 50000;
	
	public static  void main(String[] args) {
		
		//Add Numbers 0, 1, 2, ..., N - 1 to the array list
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < N; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		
		//Create hash set, and test its performance
		Collection<Integer> set1 = new HashSet<>(list);
		System.out.println("Member test time for HashSet is " + getTestTime(set1) + " milliseconds");
		System.out.println("Remove element time for HashSet is " + getRemoveTime(set1) + " milliseconds");
		
		//Create linked hash set, and test its performance
		Collection<Integer> set2 = new LinkedHashSet<>(list);
		System.out.println("Member test time for LinkedHashSet is " + getTestTime(set2) + " milliseconds");
		System.out.println("Remove element time for LinkedHashSet is " + getRemoveTime(set2) + " milliseconds");
		
		//Create a tree set, and test its performance
		Collection<Integer> set3 = new TreeSet<>(list);
		System.out.println("Member test time for TreeSet is " + getTestTime(set3) + " milliseconds");
		System.out.println("Remove element time for TreeSet is " + getRemoveTime(set3) + " milliseconds");
		
		
		//Create an array list, and test its performance
		Collection<Integer> list1 = new ArrayList<>(list);
		System.out.println("Member test time for ArrayList is " + getTestTime(list1) + " milliseconds");
		System.out.println("Remove element time for ArrayList is " + getRemoveTime(list1) + " milliseconds");
		
		//Create a linked list, and test its performance
		Collection<Integer> list2 = new LinkedList<Integer>(list);
		System.out.println("Member test time for LinkedList is " + getTestTime(list2) + " milliseconds");
		System.out.println("Remove element time for LinkedList is " + getRemoveTime(list2) + " milliseconds");
	}

	public static long getTestTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < N; i++) {
			c.contains((int)(Math.random()* 2 * N));
		}
		return System.currentTimeMillis() - startTime;
	}
	
	public static long getRemoveTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < N; i++) {
			c.remove(i);
		}
		
		return System.currentTimeMillis() - startTime;
	}
	
	

}

package com.exercise.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicateNumbers {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Integer> list = new ArrayList<>();
		
		System.out.print("Enter 10 integers: ");
		while(list.size() < 10) {
			int num = scanner.nextInt();
			list.add(num);
		}
		System.out.println(Arrays.toString(list.toArray()));
		removeDuplicate(list);
		scanner.close();
		
		
	}
	
	public static void removeDuplicate(ArrayList<Integer> list) {
		int num = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			if(list.get(i) == num) {
				list.remove(i);
			}
			num = list.get(i);
		}
		System.out.println(Arrays.toString(list.toArray()));
	}
	
}

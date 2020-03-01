package com.exercise.chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class LargestRowsAndColumns {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the array size n: ");
		int size = scanner.nextInt();
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(size);
		for(int i = 0; i < size; i++) {
			ArrayList<Integer> columns = new ArrayList<>();
			for(int j = 0; j < size; j++) {
				int num = (int)(Math.random() * 2);
				columns.add(num);
			}
			matrix.add(columns);
		}
		for(int i = 0; i < matrix.size(); i++) {
			int count = 0;
			for(int j = 0; j < matrix.get(i).size(); j++) {
				
				if(matrix.get(i).get(j).equals(1)) {
					count++;
				}
				System.out.print(matrix.get(i).get(j));
				
			}
			System.out.println(" This row has " + count + " ones.");
			
		}
		scanner.close();
	}
}
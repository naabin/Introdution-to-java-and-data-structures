package com.excercise;

import java.util.ArrayList;
import java.util.Scanner;

public class CombineTwoLists {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter 5 integers for list1 : ");
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		while(list1.size() < 5){
			list1.add(input.nextInt());
		}
		System.out.print("Enter 5 intergers for list2: ");
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		while(list2.size() < 5) {
			list2.add(input.nextInt());
		}
		ArrayList<Integer> arrayList = union(list1, list2);
		System.out.println("The combine list is " + arrayList.toString());
		input.close();

	}
	
	public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2){
		ArrayList<Integer> combineIntegers = new ArrayList<Integer>();
		combineIntegers.addAll(list1);
		combineIntegers.addAll(list2);
		return combineIntegers;
	}

}

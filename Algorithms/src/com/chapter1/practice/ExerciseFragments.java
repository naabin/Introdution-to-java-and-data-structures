package com.chapter1.practice;

import edu.princeton.cs.algs4.StdOut;

public class ExerciseFragments {
	
	public static void main(String[] args) {
//		fragmentOne();
//		fragmentTwo();
//		fragmentThree();
		System.out.println('b');
		System.out.println('b' + 'c');
		System.out.println((char)('a' + 4));
	}
	
	public static void fragmentOne() {
		double t = 9.0;
		while(Math.abs(t - 9.0/t) > 0.01) {
			t = (9.0/t + t) / 2.0;
		}
		StdOut.printf("%.5f\n", t);
	}
	
	public static void fragmentTwo() {
		long sum = 0;
		for(int i = 0; i < 1000; i++ ) {
			for(int j = 0; j < i; j++) {
				sum++;
			}
			
		}
		StdOut.println(sum);
	}
	
	public static void fragmentThree() {
		int sum = 0; 
		for(int i = 1; i < 1000; i *= 2) {
			for(int j = 0; j < i; j++) {
				sum++;
			}
		}
		StdOut.println(sum);
	}
}

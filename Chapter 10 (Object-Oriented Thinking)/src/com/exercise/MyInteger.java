package com.exercise;

import java.util.Arrays;

public class MyInteger {
	private int value;
	
	
	public MyInteger(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	public boolean isEven() {
		return value % 2 == 0;
	}
	public boolean isOdd() {
		return value % 2 != 0;
	}
	public boolean isPrime() {
		boolean isPrime = true;
		for(int divisor = 2; divisor <= value/2; divisor++) {
			if(value % divisor == 0) {
				isPrime = false;
			}
			else {
				isPrime = true;
			}
		}
		return isPrime;
	}
	public static boolean isEven(int num) {
		return num % 2 == 0;
	}
	public static boolean isOdd(int num){
		return num % 2 != 0;
	}
	public static boolean isPrime(int num) {
		boolean isPrime = true;
		for(int divisor = 2; divisor <= num/2; divisor++) {
			if(num % divisor == 0) {
				isPrime = false;
			}
			else {
				isPrime = true;
			}
		}
		return isPrime;
	}
	public boolean equals(int num) {
		return value == num;
	}
	public static String parseInt(char[] chars) {
		int[] nums = new int[chars.length];
		for(int i = 0 ; i < chars.length; i++) {
			nums[i] = chars[i];
		}
		return Arrays.toString(nums);
	}
	
	public static int parseInt(String num) {
		return Integer.parseInt(num);
	}
	
}

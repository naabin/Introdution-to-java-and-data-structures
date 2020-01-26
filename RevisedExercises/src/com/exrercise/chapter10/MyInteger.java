package com.exrercise.chapter10;



public class MyInteger {
	
	private int value;
	
	public MyInteger(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean isEven() {
		return this.value % 2 == 0;
	}
	
	public boolean isOdd() {
		return this.value % 2 == 1;
	}
	
	public boolean isPrime() {
		for (int divisor = 2; divisor < value/2; divisor++) {
			if (value % divisor == 0) {
				return false;
			}
		}
		return true;
			
	}
	
	public boolean equals(int value) {
		return this.value == value;
	}
	
	public boolean equals(MyInteger integer) {
		return this.value == integer.value;
	}
	
	public static boolean isEven(int value) {
		return value % 2 == 0;
	}
	
	public static boolean isOdd(int value) {
		return value % 2 == 1;
	}
	
	public static boolean isPrime(int value) {
		for(int divisor = 2; divisor < value/2; divisor++) {
			if(value % divisor == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] parseInt(char[] chars) {
		int[] numericValue = new int[chars.length];
		for (int i = 0; i < chars.length; i++) {
			numericValue[i] = (int)chars[i];
		}
		return numericValue;
	}
	
	public static int parseInt(String value) {
		return Integer.parseInt(value);
	}

	
	
	public static void main(String[] args) {
		MyInteger integer = new MyInteger(5);
		int value = integer.getValue();
		System.out.println(value +( integer.isEven() ? " is Even " : " is not Even"));
		System.out.println(value + (integer.isOdd() ? " is Odd" : " is not Odd" ));
		System.out.println(value + (integer.isPrime()? " is Prime number" : " is not Prime number"));
		System.out.println("-------------------");
		int[] ints = MyInteger.parseInt(new char[] {'A', 'B', 'D'});
		
		for(int i : ints) {
			System.out.println(i);
		}
	}
	
}

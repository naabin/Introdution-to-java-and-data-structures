package com.practice;

public class TestMethodOverLoading {

	public static void main(String[] args) {
		System.out.println("The maximum of 3 and 4 is " + max(3,4));
		System.out.println("The maximum of 3.0 and 5.4 is " + max(3.0, 5.4));
		System.out.println("The maximum of 3.0, 5.4, and 10.14 is " + max(3.0, 5.4, 10.14));
	}


	private static double max(double d, double e) {
		if(d > e) {
			return d;
		}
		else {
			return e;
		}
		
	}
	private static int max(int i, int j) {
		if(i > j) {
			return i;
		}
		else {
			return j;
		}
	}
	private static double max(double d, double e, double f) {
		return(max(max(d,e),f));
	}

}

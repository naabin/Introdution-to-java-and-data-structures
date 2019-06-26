package com.exercise;

public class PentagonalNumber {

	public static void main(String[] args) {
		for(int i = 1; i <= 100; i++) {
			if(i % 11 != 0) {
				System.out.printf("%7d", getPentagonalNumber(i));
			}
			else {
				System.out.println(getPentagonalNumber(i));
			}
		}
		
	}
	public static int getPentagonalNumber(int n) {
		int pentagonalNumber = (n *((3 * n) - 1))/2;
		return pentagonalNumber;
	}
}

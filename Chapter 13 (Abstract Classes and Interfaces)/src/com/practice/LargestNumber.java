package com.practice;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class LargestNumber {

	public static void main(String[] args) {
		
		ArrayList<Number> list = new ArrayList<Number>();
		list.add(45);
		list.add(3445.5);
		list.add(new BigInteger("3141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067"));
		list.add(new BigDecimal("3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067"));
		
		System.out.println("The largest number is " + getLargestNumber(list));
	}
	private static Number getLargestNumber(ArrayList<Number> list) {
		if(list == null || list.size() == 0) {
			return null;
		}
		Number number = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			if(number.doubleValue() < list.get(i).doubleValue()) {
				number = list.get(i);
			}
			
		}
		return number;
	}

}

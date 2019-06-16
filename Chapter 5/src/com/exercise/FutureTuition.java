package com.exercise;

public class FutureTuition {

	public static void main(String[] args) {
		double tutition_fee = 10000;
		
		final double TUITION_INCREAASE_RATE = 1.06;
		
		int years = 0;
		
		while(years < 10) {
			tutition_fee = tutition_fee * TUITION_INCREAASE_RATE;
		}
		
	}
	
}

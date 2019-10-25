package com.week10;

public class Truck extends Vehicle {
	
	private int mTonnage;

	public Truck(String regoNum, String make, int year, double price, int tonnage) {
		super(regoNum, make, year, price);
		this.mTonnage = tonnage;
	}

	public int getmTonnage() {
		return mTonnage;
	}

	@Override
	public String toString() {
		String message = super.toString() + "\nTonnage: " + this.mTonnage;
		return message;
	}
	
	
	
	
}

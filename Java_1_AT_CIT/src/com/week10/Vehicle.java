package com.week10;

public abstract class Vehicle {
	private String mRegoNum;
	private String mMake;
	private int mYear;
	private double mPrice;
	
	
	public Vehicle(String regoNum, String make, int year, double price) {
		this.mRegoNum = regoNum;
		this.mMake = make;
		this.mYear = year;
		this.mPrice = price;
		
	}


	public String getmRegoNum() {
		return mRegoNum;
	}


	public void setmRegoNum(String mRegoNum) {
		this.mRegoNum = mRegoNum;
	}


	public String getmMake() {
		return mMake;
	}


	public void setmMake(String mMake) {
		this.mMake = mMake;
	}


	public int getmYear() {
		return mYear;
	}


	public void setmYear(int mYear) {
		this.mYear = mYear;
	}


	public double getmPrice() {
		return mPrice;
	}


	public void setmPrice(double mPrice) {
		this.mPrice = mPrice;
	}


	@Override
	public String toString() {
		return "Vehicle [mRegoNum=" + mRegoNum + ", mMake=" + mMake + ", mYear=" + mYear + ", mPrice=" + mPrice + "]";
	}
	
	
}

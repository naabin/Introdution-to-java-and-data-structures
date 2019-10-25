package com.week10;

public class Car extends Vehicle {
	
	private boolean mNRMAInspetion;
	/**
	 * Cars initially don't have an NRMA inspection done
	 * @param regNum
	 * @param make
	 * @param year
	 * @param price
	 */
	public Car(String regNum, String make, int year, double price) {
		super(regNum, make, year, price);
		this.mNRMAInspetion = false;
	}
	public boolean ismNRMAInspetion() {
		return mNRMAInspetion;
	}
	public void setmNRMAInspetion(boolean mNRMAInspetion) {
		this.mNRMAInspetion = mNRMAInspetion;
	}
	@Override
	public String toString() {
		String message;
		if(ismNRMAInspetion()) {
			message = super.toString() + "\nInspection report avialable.";
			return message;
		}
		else {
			message = super.toString() + "\nInpection report is not available.";
			return message;
		}
	}
	
	
	
	
}

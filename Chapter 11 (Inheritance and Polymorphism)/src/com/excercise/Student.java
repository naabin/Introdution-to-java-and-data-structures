package com.excercise;

public class Student extends Person {
	public static final int FRESH_MAN=1;
	public static final int SOPHOMORE=2;
	public static final int JUNIOR=3;
	public static final int SENIOR=4;
	private int status;
	
	public Student() {
		super();
		status = FRESH_MAN;
	}
	
	public Student(int status) {
		super();
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return super.toString() + "Student [status=" + status + "]";
	}
}

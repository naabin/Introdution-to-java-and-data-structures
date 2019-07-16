package com.excercise;

import java.util.Date;

public class Employee extends Person {
	private boolean hasOffice;
	private double salary;
	private Date hiredDate;
	
	public Employee() {
		super();
		hasOffice = false;
		hiredDate = new Date();
	}
	
	public Employee(boolean hasOffice, double salary, Date hiredDate) {
		this.hasOffice = hasOffice;
		this.salary = salary;
		this.hiredDate = hiredDate;
	}

	public boolean isHasOffice() {
		return hasOffice;
	}

	public void setHasOffice(boolean hasOffice) {
		this.hasOffice = hasOffice;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}

	@Override
	public String toString() {
		return "Employee [hasOffice=" + hasOffice + ", salary=" + salary + ", hiredDate=" + hiredDate + "]";
	}
	
	
	
	
}

package com.exrercise.chapter10;

import java.util.Date;

public class Account {

	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;

	public Account() {

		this.dateCreated = new Date();

	}

	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
		this.dateCreated = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double monthlyInterest() {
		return getBalance() * getMonthlyInterestRate();
	}

	public double getMonthlyInterestRate() {
		double monthlyInterest = (getAnnualInterestRate() / 100) / 12;
		return monthlyInterest;
	}

	public void withdraw(double balance) {
		if (getBalance() > balance && balance > 0) {
			this.balance -= balance;
		}
	}

	public void deposit(double balance) {
		if (balance > 0) {
			this.balance += balance;
		}
	}

	// Program testing
	public static void main(String[] args) {
		Account account = new Account(1122, 20000);
		account.setAnnualInterestRate(4.5);
		account.withdraw(2500);
		account.deposit(3000);
		System.out.println(account.monthlyInterest());
		System.out.println(account.getDateCreated());
	}
}

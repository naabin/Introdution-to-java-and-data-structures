package com.exercise;

import java.util.Date;

public class Account {
	private int id;
	private double balance;
	private double interestRate;
	private Date dateCreated;

	public Account() {
		id = 0;
		balance = 0;
		interestRate = 0;
		dateCreated = new Date();
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

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	
	public double getMonthlyInterestRate() {
		return interestRate/12;
	}
	public double getMonthlyInterest() {
		double monthlyInterestRate = getMonthlyInterestRate();
		double monthlyInterest = (balance * monthlyInterestRate)/100;
		return monthlyInterest;
	}
	public void withdraw(double amount) {
		if(amount <= balance) {
			balance = balance - amount;
		}
		else {
			System.out.println("You are trying to withdraw " + amount);
			System.out.println("You only have " + balance + " in your account");
			System.exit(1);
		}
	}
	public void deposit(double amount) {
		if(amount >= 0) {
			balance += amount;
		}
		else {
			System.out.println(amount + " is not  a vaid amount");
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		Account newAccount = new Account(1122, 20000);
		newAccount.setInterestRate(4.5);
		newAccount.withdraw(2500);
		newAccount.deposit(3000);
		
		System.out.println("Balance: " + newAccount.getBalance());
		System.out.println("Monthly Interest: " + newAccount.getMonthlyInterest());
		System.out.println("Date of the account was created: " + newAccount.getDateCreated());
		
	}
	

}

package com.exercise.chapter11;

import java.time.LocalDate;


public class Transaction {

	private LocalDate date;
	private char type;
	private double amount;
	private double balance;
	private String description;
	
	public Transaction() {
		
		this.date = LocalDate.now();
	
	}
	
	public Transaction(char type, double amount, double balance,String description) {
		this.type = type;
		this.amount = amount;
		this.balance = balance;
		this.description = description;
		this.date = LocalDate.now();
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}

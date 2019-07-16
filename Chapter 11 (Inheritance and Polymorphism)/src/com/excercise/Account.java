package com.excercise;

import java.util.ArrayList;
import java.util.Date;

public class Account {

	private int id;
	private String name;
	private double balance;
	private double interestRate;
	private Date dateCreated;
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
	
	
	public Account() {
		id = 1;
		name = "Still unknown";
		balance = 0;
		interestRate = 0;
		dateCreated = new Date();
	}
	
	public Account(int id, String name, double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public double getMonthlyInterestRate() {
		return interestRate/12;
	}
	public double getMonthlyInterest() {
		return (balance * getMonthlyInterestRate())/100;
	}
	
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			String description = amount + " added into account";
			Transaction e = new Transaction('D', amount, balance, description );
			transactions.add(e);
		}
		else {
			System.out.println("Invalid amount.Program terminating...");
			System.exit(1);
		}
	}
	
	public void withdraw(double amount) {
		if(amount <= balance && amount > 0) {
			balance -= amount;
			String description = amount + " withdrawn";
			Transaction e = new Transaction('W', amount, balance, description );
			transactions.add(e );
		}
		else {
			System.out.println("Insufficient balance");
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {
		Account account1 = new Account(1, "Nabin", 1000);
		account1.deposit(30);
		account1.deposit(40);
		account1.deposit(50);
		account1.withdraw(2);
		account1.withdraw(3);
		account1.withdraw(4);
		
		ArrayList<Transaction> transactions = account1.getTransactions();
		
		for(Transaction transaction: transactions) {
			System.out.println(transaction);
		}
		
	}
}

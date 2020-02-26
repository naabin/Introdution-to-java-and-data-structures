package com.exercise.chapter11;

import java.util.ArrayList;
import java.util.Date;

public class Account {

	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	private ArrayList<Transaction> transactions = new ArrayList<>();

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

	public void withdraw(double balance, String description) {
		if (getBalance() > balance && balance > 0) {
			this.balance -= balance;
			Transaction transaction = new Transaction('W', balance, this.balance, description);
			this.transactions.add(transaction);
		}
	}

	public void deposit(double balance, String description) {
		if (balance > 0) {
			this.balance += balance;
			Transaction transaction = new Transaction('D', balance, this.balance, description);
			this.transactions.add(transaction);
		}
	}
	
	public void printStatements() {
		System.out.println("W = Withdraw\nD  = Deposit");
		System.out.println("Date\t\t\tType\t\tAmount\t\tBalance");
		for(Transaction transaction: transactions) {
			System.out.println(transaction.getDate()+
					"\t\t"+transaction.getType()+"=>"+transaction.getDescription()+
					"\t\t"+transaction.getAmount()+"\t\t"+transaction.getBalance());
		}
		System.out.println("----------------------------------------------------------------");
		System.out.println("Account balance is: " + this.balance);
	}

	// Program testing
	public static void main(String[] args) {
		Account account = new Account(1122, 20000);
		account.setAnnualInterestRate(4.5);
		account.withdraw(2500, "College Fee");
		account.deposit(3000, "Weekly Pay");
		account.printStatements();
	}
}

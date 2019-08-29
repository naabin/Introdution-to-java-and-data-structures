package com.week4;

public class BankAccount {

	private String accountId;
	private String name;
	private double balance;

	public BankAccount(String accountId, String name) {
		this.accountId = accountId;
		this.name = name;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public void deposit(double amount) {
		if (amount < 0) {
			System.out.println("Invalid amount");

		}
		this.balance += amount;
	}

	public void withdraw(double amount) {
		if (amount > this.balance) {
			System.out.println("Not enough amount in the bank account");
			System.out.println("Avaialbe balance is only " + this.balance);
		}

	}

	public double getBalance() {
		return this.balance;
	}

	public void printBalance() {
		System.out.println("************************");
		System.out.println(this.name + " has " + this.balance + "in the account.");
	}

}

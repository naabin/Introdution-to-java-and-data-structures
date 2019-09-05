package com.week4;

public class Bank {
	private final int MAX_ACCOUNTS = 100;
	private BankAccount[] accounts;
	private int numAccounts;
	
	public Bank() {
		this.accounts = new BankAccount[this.MAX_ACCOUNTS];
		this.numAccounts = 0;
	}
	
	public void createAccount(BankAccount account) {
		if(this.numAccounts < this.MAX_ACCOUNTS) {
			this.accounts[this.numAccounts] = account;
			this.numAccounts++;
		}
		else {
			System.out.println("Sorry the bank is full");
		}
	}
	
	public void getTotalBalance() {
		double totalBalance = 0;
		for(int i = 0; i < this.accounts.length; i++) {
			if(this.accounts[i] != null) {
				totalBalance += this.accounts[i].getBalance();
			}
		}
		
		System.out.println("The total fund in the bank " + totalBalance);
	}
	
	public void printAllBalance() {
		for(int i = 0; i < this.accounts.length; i++) {
			if(i < this.numAccounts) {
				this.accounts[i].printBalance();
			}
		}
	}
	
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		BankAccount account = new BankAccount("1234", "Peter");
		account.deposit(100);
		
		bank.createAccount(account);
		
		bank.printAllBalance();
		
		bank.getTotalBalance();
		
	}
}

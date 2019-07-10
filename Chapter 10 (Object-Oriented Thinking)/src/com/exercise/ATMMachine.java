package com.exercise;

import java.util.Scanner;

public class ATMMachine {
	public static void main(String[] args) {
		Account[] accounts = new Account[10];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, 100);
		}	
		System.out.print("Enter an id: ");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int accountId = input.nextInt();
		Account account = accounts[accountId];
		System.out.println("Main menu\n1: Check balance\n2: Withdraw\n3: Deposit\n4: Exit");
		System.out.print("Enter a choice: ");
		while(true) {
			switch (input.nextInt()) {
			case 1:
				double balance = account.getBalance();
				System.out.println("The balance is " + balance);
				break;
			case 2:
				System.out.print("Enter a amount to withdraw: ");
				double amount = input.nextDouble();
				account.withdraw(amount);
				System.out.println(amount + " withdrawn.");
				System.out.println("You have " + account.getBalance() + " available in your account.");
				break;
			case 3:
				System.out.print("Enter an amount to deposit: ");
				double depositAmount = input.nextDouble();
				account.deposit(depositAmount);
				System.out.println(depositAmount + " added into your account");
				System.out.println("You now have " + account.getBalance() + " funds available now.");
				break;
			case 4:
				System.out.println("GoodBye!!!");
				System.exit(1);
				
			default:
				break;
			}
			
		}
	}
}

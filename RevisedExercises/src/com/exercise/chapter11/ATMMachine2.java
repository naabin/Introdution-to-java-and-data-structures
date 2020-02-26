package com.exercise.chapter11;

import java.util.Scanner;

public class ATMMachine2 {

	private Account[] accounts = new Account[10];

	public ATMMachine2() {
		for (int i = 0; i < accounts.length; i++) {
			Account account = new Account(i, 100);
			accounts[i] = account;
		}
	}

	public static void main(String[] args) {
		ATMMachine2 atmMachine = new ATMMachine2();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter an id: ");

			int id = scanner.nextInt();

			String menu = "Main menu\n1:check balance\n2: withdraw\n3: deposit\n4: statement\n5: exit";

			if (id >= 0 && id <= atmMachine.accounts.length) {
				while (true) {
					System.out.println(menu);
					System.out.print("Enter a choice: ");
					int choice = scanner.nextInt();
					switch (choice) {
					case 1:
						System.out.println("The balance is " + atmMachine.accounts[id].getBalance());
						continue;
					case 2:
						System.out.print("Enter an amount to withdraw: ");
						double withdrawlAmount = scanner.nextDouble();
						System.out.print("Enter description: ");
						scanner.next();
						String description_W = scanner.nextLine();
						atmMachine.accounts[id].withdraw(withdrawlAmount, description_W);
						continue;
					case 3:
						System.out.print("Enter an amount to deposit: ");
						double depositAmount = scanner.nextDouble();
						System.out.print("Enter description: ");
						scanner.next();
						String description = scanner.nextLine();
						atmMachine.accounts[id].deposit(depositAmount, description);
						continue;
					case 4:
						System.out.println("Print Statement");
						atmMachine.accounts[id].printStatements();
						continue;
					case 5:
						System.out.println("Goodbye");
						break;
					default:
						break;
					}
					break;
				}
				continue;
			}
			scanner.close();
		}
		
	}

}

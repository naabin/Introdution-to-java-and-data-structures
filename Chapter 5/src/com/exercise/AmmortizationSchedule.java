package com.exercise;

import java.util.Scanner;

public class AmmortizationSchedule {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Loan Amount: ");
		double loan = input.nextDouble();
		System.out.print("Number of Years: ");
		int years = input.nextInt();
		System.out.print("Annual Interest Rate: ");
		double intererstRate = input.nextDouble();
		
		double totalPayment = loan;
		int num = 1;
		while(num <= years) {
			totalPayment   = totalPayment * (1 + (intererstRate/100.00));
			num++;
		}
		double montlyPayment = totalPayment/12;
		System.out.printf("Monthly Payment: %4.2f",montlyPayment );
		System.out.println();
		System.out.println("Total Payment: " + totalPayment);
		
		int numOfMonths = 1;
		double balance = loan;
		double monthlyPayment = balance/(years * 12.0);
		double monthlyInterest = 0.0;
		double principal = 0;
		System.out.println("Payment#     Interest    Principal    Balance");
		while(numOfMonths <= (years * 12)) {
			monthlyInterest = (balance * intererstRate)/(100.00 * 12.0);
			principal = monthlyPayment - monthlyInterest;
			balance = balance - principal;
			System.out.printf("%d            %4.2f          %4.2f         %4.2f", numOfMonths, monthlyInterest, principal, balance);
			System.out.println();
			numOfMonths++;
			
		}
		
		input.close();
	}
	

}

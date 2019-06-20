package com.exercise;

import java.util.Scanner;

public class CompareLoansInterestRate {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Loan Amount: ");
		double loan = input.nextDouble();
		 
		System.out.print("Number of Years: ");
		int time = input.nextInt();
		
		double minInterestRate = 5;
		double maxInterestRate = 10;
		
		double totalPayment = loan;
		
		while(minInterestRate <= maxInterestRate) {
			double interest = (loan * time * minInterestRate)/100;
			totalPayment += interest;
			System.out.printf("%.2f      %4.2f        %4.2f", minInterestRate, totalPayment/(time*12), totalPayment);
			System.out.println();
			totalPayment = loan;
			minInterestRate+=0.25;
		}
		input.close();
		
		
	}

}

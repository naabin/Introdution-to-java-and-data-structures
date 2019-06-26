package com.exercise;

import java.util.Scanner;

public class ComputeTax {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your taxable income: ");
		double taxableIncome = input.nextDouble();
		System.out.print("Enter the appropriate status; 0 for single filer,  1 for married jointly or qualifying widow(er),married separately, 3 for head of household.");
		int status = input.nextInt();
		double tax = computeTax(status, taxableIncome);
		System.out.println(taxableIncome + " has to pay " + tax + " in tax.");
		input.close();
		

	}

	/**
	 * 
	 * @param status        0 for single filer, 1 for married jointly or qualifying
	 *                      widow(er), 2 for married separately, 3 for head of
	 *                      household
	 * @param taxableIncome
	 * @return tax to be paid according to taxable income entered
	 */
	public static double computeTax(int status, double taxableIncome) {
		double tax = 0;
		if (taxableIncome > 0) {
			switch (status) {
			case 0:
				if (taxableIncome <= 8350) {
					tax = calculateTax(0.10, taxableIncome);
				} else if (taxableIncome <= 33950) {
					tax = calculateTax(0.10, 8350) + calculateTax(0.15, taxableIncome - 8350);
				} else if (taxableIncome <= 82250) {
					tax = calculateTax(0.10, 8350) + calculateTax(0.15, 33950 - 8350)
							+ calculateTax(0.25, taxableIncome - 33950);
				} else if (taxableIncome <= 171550) {
					tax = calculateTax(0.10, 8350) + calculateTax(0.15, 33950 - 8350)
							+ calculateTax(0.25, 82250 - 33950) + calculateTax(0.28, taxableIncome - 82250);
				} else if (taxableIncome <= 372950) {
					tax = calculateTax(0.10, taxableIncome) + calculateTax(0.15, 33950 - 8350)
							+ calculateTax(0.25, 82250 - 33950) + calculateTax(0.28, 171550 - 82250)
							+ calculateTax(0.33, taxableIncome - 171550);

				} else {
					tax = calculateTax(0.10, 8350) + calculateTax(0.15, 33950 - 8350)
							+ calculateTax(0.25, 82250 - 33950) + calculateTax(0.28, 171550 - 82250)
							+ calculateTax(0.33, 372950 - 171550) + calculateTax(0.35, taxableIncome - 372950);
				}
				break;
			case 1:
				if (taxableIncome <= 16700) {
					tax = calculateTax(0.10, taxableIncome);
				} else if (taxableIncome <= 67900) {
					tax = calculateTax(0.10, 16700) + calculateTax(0.15, taxableIncome - 16700);

				} else if (taxableIncome <= 137050) {
					tax = calculateTax(0.10, 16700) + calculateTax(0.15, 67900 - 16700)
							+ calculateTax(0.25, taxableIncome - 67900);
				} else if (taxableIncome <= 208850) {
					tax = calculateTax(0.10, 16700) + calculateTax(0.15, 67900 - 16700)
							+ calculateTax(0.25, 137050 - 67900) + calculateTax(0.28, taxableIncome - 137050);
				} else if (taxableIncome <= 372950) {
					tax = calculateTax(0.10, 16700) + calculateTax(0.15, 67900 - 16700)
							+ calculateTax(0.25, 137050 - 67900) + calculateTax(0.28, 208850 - 137050)
							+ calculateTax(0.33, taxableIncome - 208850);
				} else {
					tax = calculateTax(0.10, 16700) + calculateTax(0.15, 67900 - 16700)
							+ calculateTax(0.25, 137050 - 67900) + calculateTax(0.28, 208850 - 137050)
							+ calculateTax(0.33, 372950 - 208850) + calculateTax(0.35, taxableIncome - 372950);
				}
			case 2:
				if (taxableIncome <= 8350) {
					tax = calculateTax(0.10, taxableIncome);
				} else if (taxableIncome <= 33950) {
					tax = calculateTax(0.10, 8350) + calculateTax(0.15, taxableIncome - 8350);

				} else if (taxableIncome <= 68525) {
					tax = calculateTax(0.10, 8350) + calculateTax(0.15, 33950 - 8350)
							+ calculateTax(0.25, taxableIncome - 33950);
				} else if (taxableIncome <= 104425) {
					tax = calculateTax(0.10, 8350) + calculateTax(0.15, 33950 - 8350)
							+ calculateTax(0.25, 68525 - 33950) + calculateTax(0.28, taxableIncome - 68525);
				} else if (taxableIncome <= 186475) {
					tax = calculateTax(0.10, 8350) + calculateTax(0.15, 33950 - 8350)
							+ calculateTax(0.25, 68525 - 33950) + calculateTax(0.28, 104425 - 68525)
							+ calculateTax(0.33, taxableIncome - 104425);
				} else {
					tax = calculateTax(0.10, 8350) + calculateTax(0.15, 33950 - 8350)
							+ calculateTax(0.25, 68525 - 33950) + calculateTax(0.28, 104425 - 68525)
							+ calculateTax(0.33, 186475 - 104425) + calculateTax(0.35, taxableIncome - 186475);
				}
			case 3:
				if (taxableIncome <= 11950) {
					tax = calculateTax(0.10, taxableIncome);
				} else if (taxableIncome <= 45500) {
					tax = calculateTax(0.10, 11950) + calculateTax(0.15, taxableIncome - 11950);
				} else if (taxableIncome <= 117450) {
					tax = calculateTax(0.10, 11950) + calculateTax(0.15, 45500 - 11950)
							+ calculateTax(0.25, taxableIncome - 45500);
				} else if (taxableIncome <= 190200) {
					tax = calculateTax(0.10, 11950) + calculateTax(0.15, 45500 - 11950)
							+ calculateTax(0.25, 117450 - 45500) + calculateTax(0.28, taxableIncome - 117450);
				} else if (taxableIncome <= 372950) {
					tax = calculateTax(0.10, 11950) + calculateTax(0.15, 45500 - 11950)
							+ calculateTax(0.25, 117450 - 45500) + calculateTax(0.28, 190200 - 117450)
							+ calculateTax(0.33, taxableIncome - 190200);
				} else {
					tax = calculateTax(0.10, 11950) + calculateTax(0.15, 45500 - 11950)
							+ calculateTax(0.25, 117450 - 45500) + calculateTax(0.28, 190200 - 117450)
							+ calculateTax(0.33, 372950 - 190200) + calculateTax(0.35, taxableIncome - 372950);
				}

			default:
				break;
			}

		}
		else {
			System.out.println("Invalid taxable income.");
			System.exit(1);
		}
		return tax;

	}

	private static double calculateTax(double taxRate, double taxableIncome) {
		double tax = taxRate * taxableIncome;
		return tax;
	}

}

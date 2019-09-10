package com.practice;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();
		
		Locale locale = new Locale("en", "IN");
		
		NumberFormat indiaCurrencyInstnce = NumberFormat.getCurrencyInstance(locale);
		String indiaFormat = indiaCurrencyInstnce.format(payment);
		NumberFormat usCurrencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat chinaCurrencyInstance = NumberFormat.getCurrencyInstance(Locale.CHINA);
		NumberFormat franceCurrencyInstance = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		String franceFormat = franceCurrencyInstance.format(payment);
		String usFormat = usCurrencyInstance.format(payment);
		String chinaFormat = chinaCurrencyInstance.format(payment);
		System.out.println(chinaFormat);
		System.out.println(usFormat);
		System.out.println(franceFormat);
		System.out.println(indiaFormat);

		
	}

}

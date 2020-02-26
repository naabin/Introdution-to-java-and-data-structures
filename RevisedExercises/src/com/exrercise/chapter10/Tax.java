package com.exrercise.chapter10;

import java.util.Arrays;

public class Tax {
	
	public final static int SINGLE_FILER = 0;
	public final static int MARRIED_JOINTLY_OR_QUALIFYING_WIDOWER = 1;
	public final static int MARRIED_SEPARATELY = 2;
	public final static int HEAD_OF_HOUSEHOLD = 3;
	
	
	private int fillingStatus;
	
	private int [][] brackets;
	
	private double [] rates;
	
	private double taxableIcome;
	
	public Tax() {
		
	}
	
	public Tax(int fillingStatus, int[][] brackets, double[] rates, double taxableIncome) {
		this.fillingStatus = fillingStatus;
		this.brackets = brackets;
		this.rates = rates;
		this.taxableIcome = taxableIncome;
	}

	public int getFillingStatus() {
		return fillingStatus;
	}

	public void setFillingStatus(int fillingStatus) {
		this.fillingStatus = fillingStatus;
	}

	public int[][] getBrackets() {
		return brackets;
	}

	public void setBrackets(int[][] brackets) {
		this.brackets = brackets;
	}

	public double[] getRates() {
		return rates;
	}

	public void setRates(double[] rates) {
		this.rates = rates;
	}

	public double getTaxableIcome() {
		return taxableIcome;
	}

	public void setTaxableIcome(double taxableIcome) {
		this.taxableIcome = taxableIcome;
	}
	
	
	public void getTax() {
		Arrays.sort(rates);
		Arrays.sort(brackets);
		
		for(int i = 0; i < brackets.length; i++) {
			for(int j = 0; j < rates.length; j++) {
				double ratesInDecimal = rates[j]/100;
				double tax  = ratesInDecimal * brackets[i][1];
				System.out.println("The tax for " + brackets[i][1] +  " with the rate " + rates[j] + "% is " + tax );
			}
		}
		
	}
	//Program testing
	public static void main(String[] args) {
		Tax tax = new Tax(SINGLE_FILER, new int[][] {{0,27050}}, new double[] {15, 27.5, 30.5, 35.5, 39.1}, 60000);
		tax.getTax();
	}
	

}

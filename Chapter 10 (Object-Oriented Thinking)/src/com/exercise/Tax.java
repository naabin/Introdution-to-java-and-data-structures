package com.exercise;

public class Tax {
	public final static int  SINGLE_FILER = 0;
	public final static int MARRIED_JOINTYLY_OR_QUALIFYING_WIDOW = 1;
	public final static int MARRIED_SEPARATELY = 2;
	public final static int HEAD_OF_HOUESEHOLD = 3;
	
	
	private int filingStatus;
	private int [][] brackets;
	private double [] rates;
	private double taxableIncome;
	
	public Tax() {
	}
	
	public Tax(int filingStatus, int[][]brackets, double[] rates, double taxableIncome) {
		this.filingStatus = filingStatus;
		this.brackets = brackets;
		this.rates = rates;
		this.taxableIncome = taxableIncome;
	}

	public int getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(int filingStatus) {
		this.filingStatus = filingStatus;
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

	public double getTaxableIncome() {
		return taxableIncome;
	}

	public void setTaxableIncome(double taxableIncome) {
		this.taxableIncome = taxableIncome;
	}
	public double getTax() {
		double tax = 0;
		for(int i = 0; i < brackets.length; i++) {
			if(brackets[i][1] < taxableIncome) {
				tax += rates[i] * brackets[i][1];
				taxableIncome -= brackets[i][1];
			}
			else {
				tax += rates[i] * taxableIncome;
				taxableIncome = 0;
			}
		}
		return tax;
	}
	//Test 
	public static void main(String[] args) {
		Tax tax = new Tax(SINGLE_FILER, new int[][] {{0, 20000}}, new double [] {0.15}, 20000) ;
		double d = tax.getTax();
		System.out.println(d);
	}
}

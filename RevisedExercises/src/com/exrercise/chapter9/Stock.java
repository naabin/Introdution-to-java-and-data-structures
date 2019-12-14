package com.exrercise.chapter9;


public class Stock {

	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;

	public Stock(String symbol, String name, double previousClosingPrice, double currentPrice) {
		this.symbol = symbol;
		this.name = name;
		this.previousClosingPrice = previousClosingPrice;
		this.currentPrice = currentPrice;
	}
	
	public double getChangePercent() {
		return (currentPrice - previousClosingPrice)/100;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSymbol() {
		return this.symbol;
	}
	
	
	public static void main(String[] args) {
		Stock stock = new Stock("ORCL", "Oracle", 34.5, 35.35);
		
		System.out.println("Percent changed: " + stock.getChangePercent());
	}

}

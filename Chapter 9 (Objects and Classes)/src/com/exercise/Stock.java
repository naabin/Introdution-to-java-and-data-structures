package com.exercise;

public class Stock {
	private String symbol;
	private String name;
	private double previousClosingPrice;
	private double currentPrice;

	public Stock(String symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPreviousClosingPrice() {
		return previousClosingPrice;
	}

	public void setPreviousClosingPrice(double previousClosingPrice) {
		this.previousClosingPrice = previousClosingPrice;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public double getChangePercent() {
		return (currentPrice - previousClosingPrice)/100.0;
	}
	
	public static void main(String[] args) {
		Stock stock = new Stock("ORCL", "Oracle");
		stock.setPreviousClosingPrice(34.5);
		stock.setCurrentPrice(34.35);
		System.out.println(stock.getSymbol() + ": " + stock.getName() + " closing price: " + stock.getPreviousClosingPrice() + ", current price: " + 
		stock.getCurrentPrice() + " and changes is " + stock.getChangePercent() + "%");
	}
}

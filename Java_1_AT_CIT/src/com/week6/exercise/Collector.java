package com.week6.exercise;

public class Collector {
	
	private String name;
	private final int MAX_WEEKS = 4;
	private double[] weights = new double[this.MAX_WEEKS];
	
	public Collector(String name, String [] weights) {
		this.name = name;
		try {
			for(int i = 0; i < this.MAX_WEEKS; i++) {
				this.weights[i] = Double.parseDouble(weights[i]);
			}
		} catch(NumberFormatException ex) {
			ex.printStackTrace();
		}
	}
	
	public Collector(String name, double[] weights) {
		this.name = name;
		this.weights = weights;
	}
	
	public String calculateTotal() {
		double total = 0;
		for(int i =0; i < this.weights.length; i++) {
			total += this.weights[i];
		}
		
		String message = this.name + ", " + total;
		return message;
	}
}

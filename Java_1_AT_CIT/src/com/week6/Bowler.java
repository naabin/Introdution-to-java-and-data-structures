package com.week6;

public class Bowler {
	
	private String name;
	private final int MAX_GAMES = 3;
	private int[] scores = new int[this.MAX_GAMES];
	
	
	public Bowler(String inName, int[] scores) {
		this.name = inName;
		this.scores = scores;
	}
	
	public Bowler(String name, String[] scores) {
		this.name = name;
		try {
			for(int i = 0; i < MAX_GAMES; i++) {
				this.scores[i] = Integer.parseInt(scores[i]);
			}
			
		}catch(NumberFormatException ex) {
			ex.printStackTrace();
		}
	}
	
	public String calculateAverage() {
		int total = 0;
		for(int i = 0; i < this.MAX_GAMES; i++) {
			total += this.scores[i];
		}
		double average = (total * 1.0)/this.MAX_GAMES;
		
		return this.name + ", " + average;
	}

}

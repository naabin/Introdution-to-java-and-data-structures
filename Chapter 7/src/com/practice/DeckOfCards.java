package com.practice;

public class DeckOfCards {

	public static void main(String[] args) {
		int[] deck = new int[52];
		
		String [] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
		String [] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
		//initialize the cards
		for(int i = 0; i < deck.length; i++) {
			deck[i] = i;
		}
		
		//shuffle the cards
		for(int i = 0; i < deck.length; i++) {
			//Generate an index randomly
			int index = (int)(Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
		
		// Display the first four cards 
		for(int i = 0; i < 4; i++) {
			//Determine the suit of the card;
			String suit = suits[deck[i] / 13];
			
			// Determine the rank of the card
			String rank = ranks[deck[i] % 13]; 
			
			System.out.println("Card Number " + deck[i] + ": " + rank + " of " + suit);
		}
	}

}

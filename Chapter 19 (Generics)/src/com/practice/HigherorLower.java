package com.practice;

import java.util.Random;
import java.util.Scanner;

public class HigherorLower {

	private int secretNumber;
	private int numGuesses;
	
	
	public HigherorLower() {
		newGame();
	}
	
	public void newGame() {
		Random random = new Random();
		this.secretNumber = random.nextInt(100);
		this.numGuesses = 0;
	}
	
	public void guess(int guessNum) {
		
		while(true) {
			int guess = guessNum;
			if(guess == this.secretNumber) {
				System.out.println("Congratualations!!!");
				System.out.println("You got it right");
				System.out.println("Total number of guesses " + this.numGuesses);
				break;
		
			}
			else if(guess < this.secretNumber) {
				System.out.println("The number is too low");
				
			}
			else {
				System.out.println("The number is too high");
				
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		HigherorLower game = new HigherorLower();
		System.out.println("**********************");
		System.out.println("Welcome to the Higher or Lower Game");
		System.out.print("Enter an integer to guess the number: ");
		Scanner input = new Scanner(System.in);
		
		
		while(true) {
			int guess = input.nextInt();
			if(guess == game.secretNumber ) {
				System.out.println("Congratualations!!!");
				System.out.println("You got it right");
				System.out.println("Total number of guesses " + game.numGuesses);
				break;
			}
			else if(guess < game.secretNumber) {
				System.out.println("The number is too low");
				System.out.println("Total number of guesses " + game.numGuesses);
				System.out.print("Enter an integer to guess the number: ");
			}
			else if(guess > game.secretNumber) {
				System.out.println("The number is too high");
				System.out.println("Total number of guesses " + game.numGuesses);
				System.out.print("Enter an integer to guess the number: ");
			}
			else {
				System.out.println("Something is absolutely wrong with this game.");
				System.exit(1);
			}
			game.numGuesses++;
		}
		
		input.close();
	}
}

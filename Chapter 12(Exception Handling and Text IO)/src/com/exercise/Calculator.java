package com.exercise;
public class Calculator {

	public static void main(String[] args) {
		
		boolean isInoutRight = true;
		do {
			try {
				int firstOperand = Integer.parseInt(args[0]);
				int secondOperand = Integer.parseInt(args[2]);
				int result  = 0;
				switch (args[1]) {
				case "+":
					result  = firstOperand + secondOperand;
					System.out.println(firstOperand + " + " + secondOperand + " = " + result);
					
				case "-":
					result = firstOperand - secondOperand;
					System.out.println(firstOperand + " - " + secondOperand + " = " + result);
					
				case "/":
					try {
						result = firstOperand / secondOperand;
						System.out.println(firstOperand + " / " + secondOperand + " = " + result);
					}
					catch(ArithmeticException ex) {
						System.out.println("Cannot divide by zero.");
						System.out.println(ex.getLocalizedMessage());
					}
					
				case "%":
					result = firstOperand % secondOperand;
					System.out.println(firstOperand + " % " + secondOperand + " = " + result);
					

				default:
					break;
				}
			}
			catch(NumberFormatException ex) {
				System.out.println("Wrong input");
				System.out.println(ex.getLocalizedMessage());
				
			}
			isInoutRight = false;
		}
		while(isInoutRight);
	}

}

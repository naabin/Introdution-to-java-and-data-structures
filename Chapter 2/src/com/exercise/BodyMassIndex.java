package com.exercise;

import java.util.Scanner;

public class BodyMassIndex {

	public static void main(String[] args) {
		System.out.print("Enter weight in pounds: ");
		Scanner input = new Scanner(System.in);
		double weight = input.nextDouble();
		System.out.print("Enter feet: ");
		double feet = input.nextDouble();
		System.out.print("Enter inches: ");
		double inches = input.nextDouble();
		
		String message = "";
		String determinedBMI = "";
		
		double KILOGRAMS_PER_POUND = 0.45359237;
		double METERS_PER__INCH = 0.0254;
		
		double totalHeight = (( feet * 12) + inches) * METERS_PER__INCH;
		double weightInKilograms = weight * KILOGRAMS_PER_POUND;
		
		double bmiIndex = Math.round((weightInKilograms/Math.pow(totalHeight, 2)));
		
		if(bmiIndex  < 18.5) {
			message = " BMI is " + bmiIndex;
			determinedBMI = "Underweight";
			
		}
		else if(bmiIndex > 18.5 && bmiIndex < 25) {
			message = "BMI is " + bmiIndex;
			determinedBMI = "Normal";
		}
		else if(bmiIndex > 25 && bmiIndex < 30) {
			message = "BMI is " + bmiIndex;
			determinedBMI = "Overweight";
		}
		else {
			message = "BMI is " + bmiIndex;
			determinedBMI = "Obese";
			System.out.println("Its time to workout");
		}
		System.out.println(message);
		System.out.println(determinedBMI);
		input.close();
	}

}

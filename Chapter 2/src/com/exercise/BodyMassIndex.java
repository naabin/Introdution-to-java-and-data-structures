package com.exercise;

import java.util.Scanner;

public class BodyMassIndex {

	public static void main(String[] args) {
		System.out.print("Enter weight in kilograms: ");
		Scanner input = new Scanner(System.in);
		double weight = input.nextDouble();
		System.out.print("Enter heigth in centimetres: ");
		double height = input.nextDouble();
	
		
		
		String message = "";
		String determinedBMI = "";
		
//		final double KILOGRAMS_PER_POUND = 0.45359237;
//		final double METERS_PER__INCH = 0.0254;
	
		double bmiIndex = Math.round((weight/Math.pow((height/100), 2)));
		
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

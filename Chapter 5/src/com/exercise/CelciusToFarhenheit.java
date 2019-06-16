package com.exercise;

public class CelciusToFarhenheit {

	public static void main(String[] args) {
		System.out.println( "Celcius        Fahrenheit");
		for(int i = 0; i <= 100; i+=2) {
			double f = i*1.0*9/5 + 32;
			System.out.println(i + "                  " + f);
		}
	}

}


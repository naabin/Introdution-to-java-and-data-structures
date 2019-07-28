package com.exercise;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DisplayCalendar {
	
	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);
		System.out.print("Enter a month, ex: 1 for Jan, 2 for Feb: ");
		int month = input.nextInt();
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		
		Calendar calendar = new GregorianCalendar(year, month, 0);
		
		String [] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		
		String[] months = {"January", "February", "March", 
				"April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		System.out.println("              " +months[month-1]+ ", " + year);
		System.out.println("---------------------------------------------");
		for(String day: days) {
			System.out.print(day + "  ");
		}
		System.out.println();
		int maxDay = calendar.get(Calendar.DAY_OF_MONTH);
		
		for(int i = 1; i <= maxDay; i++) {
			if(i % 7 == 0) {
				System.out.println(i + "    ");
			}
			else {
				System.out.print(i + "    ");
			}
			
		}
		input.close();
		
		
	}

}

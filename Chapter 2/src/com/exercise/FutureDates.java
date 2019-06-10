package com.exercise;

import java.util.Scanner;

public class FutureDates {

	public static void main(String[] args) {
		System.out.print("Enter the today's date: ");
		Scanner input = new Scanner(System.in);
		int dayInNumber = input.nextInt();
		System.out.print("Enter the number of days elapsed since today: ");
		int upcomingDay = input.nextInt();
		
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String message = "";
		int futureDay = dayInNumber + (upcomingDay % 7);
		
		
		switch (dayInNumber) {
		case 0:
			message = "Today is " + days[dayInNumber] + " and the future day is " + days[futureDay];
			break;
		case 1:
			message = "Today is " + days[dayInNumber] + " and the future day is " + days[futureDay];
			break;
		case 2: 
			message = "Today is " + days[dayInNumber] + " and the future day is " + days[futureDay];
			break;
		case 3:
			message = "Today is " + days[dayInNumber] + " and the future day is " + days[futureDay];
			break;
		case 4:
			message = "Today is " + days[dayInNumber] + " and the future day is " + days[futureDay];
			break;
		case 5:
			message = "Today is " + days[dayInNumber] + " and the future day is " + days[futureDay];
		case 6:
			message = "Today is " + days[dayInNumber] + " and the future day is " + days[futureDay];
			break;
		default:
			break;
		}
		System.out.println(message);
		input.close();
	}

}

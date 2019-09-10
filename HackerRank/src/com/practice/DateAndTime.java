package com.practice;

import java.text.DateFormatSymbols;
import java.util.Calendar;


public class DateAndTime {
	
	public static void main(String[] args) {
		System.out.println(findDay(8, 05, 2015));
	}
	
	public static String findDay(int month, int day, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month-1, day);
//		return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_STANDALONE, Locale.getDefault()).toUpperCase();
		return new DateFormatSymbols().getWeekdays()[calendar.get(Calendar.DAY_OF_WEEK)].toUpperCase();
	}

}

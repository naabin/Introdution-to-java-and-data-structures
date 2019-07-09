package com.exercise;

import java.util.Date;

public class Time {
	
	private long hour;
	private long minute;
	private long second;
	
	
	public Time() {
		long currentTimeMillis = System.currentTimeMillis();
		Date date = new Date(currentTimeMillis);
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
	}
	
	public Time(long time) {
		Date date = new Date(time);
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
	}
	
	public Time(int hours, int minutes, int seconds) {
		Date date = new Date();
		date.setHours(hours);
		date.setMinutes(minutes);
		date.setSeconds(seconds);
		
		hour = date.getHours();
		minute = date.getMinutes();
		second = date.getSeconds();
	}
	
	@Override
	public String toString() {
		return hour + ":" + minute + ":" + second;
	}

	public long getHour() {
		return hour;
	}

	public long getMinute() {
		return minute;
	}

	public long getSecond() {
		return second;
	}
}


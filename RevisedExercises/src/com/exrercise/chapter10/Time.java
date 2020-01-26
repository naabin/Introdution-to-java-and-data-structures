package com.exrercise.chapter10;

import java.time.LocalDateTime;
import java.util.Date;


public class Time {

	private int hour;
	private int minutes;
	private int seconds;
	
	
	public Time() {
		this.hour = LocalDateTime.now().getHour();
		this.minutes = LocalDateTime.now().getMinute();
		this.seconds = LocalDateTime.now().getSecond();
	}
	
	@SuppressWarnings("deprecation")
	public Time(Long elapsedTime) {
		Date date = new Date(elapsedTime);
		this.hour = date.getHours();
		this.minutes = date.getMinutes();
		this.seconds = date.getHours();
	}
	
	public Time(int hour, int minutes, int seconds) {
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}
	
	public int getHour() {
		return this.hour;
	}
	
	public int getMinutes() {
		return this.minutes;
	}
	
	public int getSeconds() {
		return this.seconds;
	}
	
	public void setTime(Long elapsedTime) {
		LocalDateTime time = LocalDateTime.ofEpochSecond(elapsedTime, 0, null);
		this.hour = time.getHour();
		this.minutes = time.getMinute();
		this.seconds = time.getSecond();
	}
	
	public static void main(String[] args) {
		Time time = new Time((long) 555550000);
		System.out.println(time.hour + ":" + time.minutes + ":" + time.minutes);
	}
}

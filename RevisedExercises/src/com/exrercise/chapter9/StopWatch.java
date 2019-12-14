package com.exrercise.chapter9;

import java.time.LocalDate;

public class StopWatch {

	private LocalDate startTime;
	private LocalDate endTime;
	
	public StopWatch() {
		this.startTime = LocalDate.now();
	}
	
	public void start() {
		this.startTime = LocalDate.now();
	}
	
	public void stop() {
		this.endTime = LocalDate.now();
	}
	
	public long getElapsedTime() {
		return LocalDate.now().toEpochDay() - this.startTime.toEpochDay();
	}
	
	public LocalDate getEndTime() {
		return this.endTime;
	}
}

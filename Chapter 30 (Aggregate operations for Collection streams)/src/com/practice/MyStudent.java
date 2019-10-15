package com.practice;

public class MyStudent {
	
	private String firstName;
	private String lastName;
	private String major;
	private int age;
	private double score;
	
	public MyStudent(String firstName, String lastName, String major, int age, double score) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.major = major;
		this.age = age;
		this.score = score;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMajor() {
		return major;
	}

	public int getAge() {
		return age;
	}

	public double getScore() {
		return score;
	}

}

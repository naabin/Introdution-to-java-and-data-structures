package com.exercise;

public class Fan {
	final private static int SLOW = 1;
	final private static int  MEDIUM = 2;
//	final private static int  FAST  = 3;
	
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	
	public Fan() {
		speed = SLOW;
		on = false;
		radius = 5;
		color = "blue";
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		String message = "";
		if(!on) {
			message = "Fan is off, it's color is " + color.toUpperCase() + " and it's radius is " + radius; 
		}
		else {
			message = "Fan speed: " + speed + "\nColor: " + color.toUpperCase() + "\nRadius: " + radius;
		}
		return message;
		
	}
	
	public static void main(String[] args) {
		Fan newFan  = new Fan();
		newFan.setOn(true);
		newFan.setColor("white");
		newFan.setRadius(10);
		newFan.setSpeed(MEDIUM);
		String string = newFan.toString();
		System.out.println(string);
	}
}

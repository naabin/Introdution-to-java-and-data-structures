package com.exercise;

import java.util.Date;

public abstract class GeometricObject implements Comparable<GeometricObject> {
	private String color = "white";
	private boolean filled;
	private Date dateCreated;
	
	protected GeometricObject() {
		dateCreated = new Date();
	}
	
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new Date();
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public  GeometricObject max(GeometricObject obj) {
		if(this.getArea() < obj.getArea()) {
			return obj;
		}
		else {
			return this;
		}
	}

	@Override
	public String toString() {
		return "GeometricObject [color=" + color + ", filled=" + filled + ", dateCreated=" + dateCreated + "]";
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();
	public abstract String getClassName();
}

package com.exrercise.chapter9;

import java.util.Scanner;

public class Location {

	private int row;
	private int column;
	public double maxValue;

	public Location(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public Location() {

	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
	
	public double getMaxValue() {
		return this.maxValue;
	}

	@Override
	public String toString() {
		return "Location [row=" + row + ", column=" + column + ", maxValue=" + maxValue + "]";
	}

	public static Location locateLargest(double[][] a) {
		Location location = new Location();
		for (int i = 0; i < a.length; i++) {
			double maxValue = a[0][0];
			for (int j = 0; j < a[i].length; j++) {
				if (maxValue < a[i][j]) {
					location.setRow(i);
					location.setColumn(j);
					location.maxValue = a[i][j];
				}
			}
		}
		return location;
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of rows and columns in the array: ");
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		
		double[][] a = new double[rows][columns];
		System.out.println("Enter the array: ");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				a[i][j] = scanner.nextDouble(); 
			}
		}
		
		for(int i = 0; i < a.length; i++ ) {
			for(int j = 0; j < i; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		Location locateLargest = Location.locateLargest(a);
		System.out.println(locateLargest);
		
		scanner.close();
	}
}

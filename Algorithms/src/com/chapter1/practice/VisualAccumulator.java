package com.chapter1.practice;

import java.util.Scanner;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class VisualAccumulator {

	private double total;
	private int N;
	
	
	public VisualAccumulator(int trials, double max) {
		StdDraw.setXscale(0, trials);
		StdDraw.setYscale(0, max);
		StdDraw.setPenRadius(.005);
	}
	
	public void addDataValue(double value) {
		N++;
		total += value;
		StdDraw.setPenColor(StdDraw.DARK_GRAY);
		StdDraw.point(N, value);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(N, total/N);
	}
	
	public double mean() {
		return total/N;
	}
	
	@Override
	public String toString() {
		return "Mean (" + N + " values): " + String.format("%7.5f", mean());
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the value: ");
		int T = scanner.nextInt();
		VisualAccumulator accumulator = new VisualAccumulator(T, 1.0);
		for(int t = 0; t < T; t++) {
			accumulator.addDataValue(StdRandom.random());
		}
		System.out.println(accumulator);
		scanner.close();
	}
	
}

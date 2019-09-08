package com.practice;

import java.util.Scanner;

public class StaticInitializer {

	private static  int B = variableInitializer();
	private static  int H = variableInitializer2();
	private static  boolean flag = true;
	
	
	public static int variableInitializer() {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		try {
			if(num < 0) {
				throw new Exception("Breadth and heigth must be positive.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return num;
	}
	public static int variableInitializer2() {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		try {
			if(num < 0) {
				throw new Exception("Breadth and heigth must be positive.");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return num;
	}
	
	
	public static void main(String[] args){
			if(flag){
				int area=B*H;
				System.out.print(area);
			}
			
		}

}

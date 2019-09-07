package com.practice;

import java.util.Scanner;

public class StaticInitializer {

	private static  int B = variableInitializer();
	private static  int H = variableInitializer();
	private static  boolean flag = true;
	
	public static int variableInitializer() {
		System.out.print("Enter a num: ");
		Scanner in = new Scanner(System.in);
		int num = 0;
		try {
			int nextInt = in.nextInt();
			if(nextInt < 0) {
				throw new Exception("Breadth and height must be positive");
			}
			else {
				num = nextInt;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public static void main(String[] args){
			if(flag){
				int area=B*H;
				System.out.print(area);
			}
			
		}//end of mai

}

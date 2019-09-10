package com.practice;

import java.util.Scanner;

public class StaticInitializer {

	private static  int B;
	private static  int H;
	private static  boolean flag = true;
	
	static {
		Scanner in = new Scanner(System.in);
		B = in.nextInt();
		H = in.nextInt();
		in.close();
		if(B < 0 || H < 0) {
			System.out.println("java.lang.Exception: Breadth and height must be positive.");
		}
		
	}

	
	
	public static void main(String[] args){
			if(flag){
				int area=B*H;
				System.out.print(area);
			}
			
		}

}

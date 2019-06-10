package com.exercise;


public class RandomMonth {

	public static void main(String[] args) {
		
		int randomNum = (int)(Math.random() * 12);
		
		String result = "";
		
		switch (randomNum) {
		case 0:
			result="January";
			break;
		case 1:
			result = "February";
			break;
		case 2:
			result ="March";
			break;
		case 3:
			result ="April";
			break;
		case 4:
			result ="May";
			break;
		case 5:
			result ="June";
			break;
		case 6:
			result = "July";
		case 7:
			result = "August";
			break;
		case 8:
			result ="September";
			break;
		case 9:
			result ="October";
			break;
		case 10:
			result = "November";
			break;
		case 11:
			result ="December";
			break;

		default:
			break;
		}
		System.out.println(result);
		
	}

}

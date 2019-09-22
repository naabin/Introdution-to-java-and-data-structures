package com.extra;

import java.util.Scanner;

public class BinaryToStringAndViceVersa {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			System.out.print("Enter a word:");
			String words = in.nextLine();
			System.out.println("Binary representaion of " + words + " is: \n" + stringToBinary(words.trim()) + "\n");
			System.out.println("********************");
			System.out.println(stringToBinary(words) + " back to string representation is "
					+ binaryToString(stringToBinary(words)));
		} catch (Exception e) {
			System.out.println("Enter a valid string: " + e);
		}

		in.close();
	}

	public static String stringToBinary(String s) {
		String binaryString = "";
		for (int i = 0; i < s.trim().length(); i++) {

			binaryString += Integer.toBinaryString(s.charAt(i));

		}
		return binaryString;
	}

	public static String binaryToString(String binary) {
		String s = "";
		for (int i = 0; i < binary.length(); i += 7) {
			String temp = binary.substring(i, i + 7);
			int parseInt = Integer.parseInt(temp, 2);
			char letter = (char) parseInt;
			s += letter;
		}
		return s;
	}

}

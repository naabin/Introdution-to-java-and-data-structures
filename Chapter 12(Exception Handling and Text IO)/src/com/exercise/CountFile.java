package com.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountFile {

	public static void main(String[] args) throws FileNotFoundException {
		
		int characters = 0;
		
		File file = new File("scores.txt");
		
		Scanner scan = new Scanner(file);
		
		while(scan.hasNext()) {
			String count = scan.next();
			if(count == " ") {
				count += 0;
			}
			else {
				characters += countChar(count);
			}
		}
		System.out.println(characters);
		scan.close();
	}
	

	private static int countChar(String next) {
		int count = 0;
		for(int i = 0; i < next.length(); i++) {
			count += next.charAt(i);
		}
		return count;
	}

}

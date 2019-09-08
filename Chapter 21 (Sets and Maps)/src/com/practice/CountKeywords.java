package com.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountKeywords {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a java source file: ");
		String fileName = in.nextLine();
		File file = new File(fileName);
		if(file.exists()) {
			System.out.println("The number of keywords in " + fileName + " is " + countKeywords(file));
		}
		else {
			System.out.println("File " + fileName + " does not exist");
		}
		in.close();
	}

	private static int countKeywords(File file) throws FileNotFoundException {
		String[] keywordString = {"abstract", "assert", "boolean", "break", "byte",
				"case", "catch", "char", "class", "const", "continue", "default", "do",
				"double", "else", "enum", "if", "implements", "import", "instanceof", "int",
				"interface", "long", "native", "new", "package", "private", "protected",
				"public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
				"this", "throw", "throws", "transient", "try", "void" ,"volatile", "while", "true",
				"false", "null"};
		Set<String> keywordSet = new HashSet<>(Arrays.asList(keywordString));
		int count = 0;
		
		Scanner input = new Scanner(file);
		while(input.hasNext()) {
			String word = input.next();
			if(keywordSet.contains(word)) {
				count++;
			}
		}
		input.close();
		return count;
	}

}

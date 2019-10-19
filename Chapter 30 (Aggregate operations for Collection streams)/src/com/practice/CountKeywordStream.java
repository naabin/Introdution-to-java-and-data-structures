package com.practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class CountKeywordStream {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a java source file: ");
		String fileName = in.nextLine();
		
		File file = new File(fileName);
		if(file.exists()) {
			System.out.println("The number of keywords in " + fileName + " is " + countKeywords(file));
		}
		else {
			System.out.println("File " + fileName + " does not exists");
		}
		
		in.close();
	}
	
	
	public static long countKeywords(File file ) throws IOException {
		String[] keywordString = {
				"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
				"class", "const", "continue", "default", "do", "double", "else", "enum",
				"extends", "for", "final", "finally", "float", "goto", "if", "implements",
				"import", "instanceof", "int", "interface", "long", "native", "new", "package",
				"private", "protected", "public", "return", "short", "static", "stricfp",
				"super", "switch", "synchronized", "this", "throw", "throws", "transient",
				"try", "void", "volatile", "while", "true", "false", "null"
		};
		
		Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywordString));
		return Files.lines(file.toPath()).parallel()
				.mapToLong(line -> Stream.of(line.split("[\\s++]"))
				.filter(word -> keywordSet.contains(word)).count())
				.sum();
	}

}

package com.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class SyntaxHighlighting {
	
	public static void main(String[] args) throws IOException {
		
			if(args.length < 1) {
				System.out.println("This program takes a parameter to run.");
				System.exit(1);
			}
			
			
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			
			String[] fileName = args[0].split("[/, .]");
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName[3]+".html"));
			
			writer.write(args[0] + " converted into html on " + new Date() + "\nBy Nabin.\n");
			System.out.println("Writing into .html file...");
			String readLine = reader.readLine();
			String[] keywordString = {"abstract", "assert", "boolean", "break", "byte",
					"case", "catch", "char", "class", "const", "continue", "default", "do",
					"double", "else", "enum", "if", "implements", "import", "instanceof", "int",
					"interface", "long", "native", "new", "package", "private", "protected",
					"public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
					"this", "throw", "throws", "transient", "try", "void" ,"volatile", "while", "true",
					"false", "null"};
			
			Set<String> keyWords = new HashSet<>(Arrays.asList(keywordString));
			System.out.println(keyWords);
			while(readLine != null) {
				System.out.println();
				writer.write(readLine + "\n");
				readLine = reader.readLine();
			}
			System.out.println("Process successfully completed.");
			reader.close();
			writer.close();
			
	}

}

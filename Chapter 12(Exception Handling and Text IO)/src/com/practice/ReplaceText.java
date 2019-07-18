package com.practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {

	public static void main(String[] args) throws FileNotFoundException {
		
		if(args.length != 4) {
			System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr new String");
			System.exit(1);
		}
		
		File sourceFile = new File(args[0]);
		if(!sourceFile.exists()) {
			System.out.println("Source file " + args[0] + " does not exist.");
			System.exit(2);
		}
		File targetFile = new File(args[1]);
		if(targetFile.exists()) {
			System.out.println("Target file " + args[1] + " already exists.");
			System.exit(3);
		}
		
		try(
				Scanner input  = new Scanner(sourceFile);
				PrintWriter output = new PrintWriter(targetFile);
			){
			String s1 = input.nextLine();
			String s2 = s1.replace(args[2], args[3]);
			output.println(s2);
		}

	}

}

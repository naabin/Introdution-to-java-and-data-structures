package com.exercise.chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteFile {

	public static void main(String[] args) {		
		
		if(args.length != 2) {
			System.out.println("It requires at least 2 parameters");
			System.exit(1);
		}
		File file = new File(args[1]);
		if(!file.exists()) {
			System.out.println("The given file " + args[1] + " does not exists.");
			System.exit(2);
		}
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String  line = scanner.nextLine();
				System.out.println(line);
				scanner.next();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

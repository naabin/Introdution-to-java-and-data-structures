package com.practice;

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

public class DirectorySizeStream {
	
	public static void main(String[] args) {
		System.out.print("Enter a directory or a file: ");
		Scanner in = new Scanner(System.in);
		String directory = in.nextLine();
		
		//Display the size
		System.out.println(getSize(new File(directory)) + " bytes");
		
		in.close();
		
	}

	private static long getSize(File file) {
		if(file.isFile()) {
			return file.length();
		}
		else {
			try {
				return Files.list(file.toPath()).parallel()
						.mapToLong(e -> getSize(e.toFile()))
						.sum();
			} catch (Exception e) {
				return 0;
			}
		}
	}

}

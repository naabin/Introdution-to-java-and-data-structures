package com.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveTextFromFile {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("scores.txt");
		Scanner input = new Scanner(file);
		ArrayList<String> fileContent = new ArrayList<String>();

		while (input.hasNext()) {
			fileContent.add(input.next());
		}
		if (fileContent.contains(args[0])) {
			fileContent.remove(args[0]);
		}
		System.out.println(fileContent.toString());
		PrintWriter modifiedFile = new PrintWriter(file);
		for (String content : fileContent) {
			modifiedFile.print(content+ " ");
			
		}
		modifiedFile.close();

		input.close();
	}

}

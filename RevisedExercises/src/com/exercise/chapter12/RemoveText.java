package com.exercise.chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveText {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java RemoveText textToRemove:string filename");
			System.exit(1);
		}
		File sourceFile = new File(args[1]);
		if (!sourceFile.exists()) {
			System.out.println("Source file " + args[1] + " does not exist");
			System.exit(2);
		}
		remove(args[0], sourceFile);

	}

	public static void remove(String text, File file) {
		String replacedString = "";
		try (
				Scanner input = new Scanner(file);
				) {
			while (input.hasNext()) {
				String line = input.nextLine();
				if(line.contains(text)) {
					replacedString += line.replace(text, "");
				}
				else {
					replacedString += line + "\n";
					
				}
			}
			System.out.println(replacedString);
			input.close();
			PrintWriter writer = new PrintWriter(file);
			writer.println(replacedString);
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package com.practice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class ReadFileFromURL {

	public static void main(String[] args) {
		System.out.print("Enter a url: ");
		Scanner scanner1 = new Scanner(System.in);
		String URLString = scanner1.next();
		
		URL url;
		try {
			url = new URL(URLString);
			int count = 0;
			Scanner scanner = new Scanner(url.openStream());
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				count += line.length();
			}
			System.out.println("The file size is " + count + " characters");
			scanner.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		scanner1.close();
		
	}

}

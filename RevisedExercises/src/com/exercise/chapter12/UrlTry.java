package com.exercise.chapter12;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class UrlTry {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a URL: ");
		String urlString = scanner.next();
		URL url = new URL(urlString);
		System.out.println("Authority " + url.getAuthority());
		System.out.println(url.getContent());
		scanner.close();
	}
}

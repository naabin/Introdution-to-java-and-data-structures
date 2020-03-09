package com.exercise.chapter12;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebCrawler {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a url: ");
		String url = input.nextLine();
		crawler(url);
		input.close();
	}
	
	
	
	public static void crawler(String startingUrl) {
		ArrayList<String> listOfPendingURLs = new ArrayList<>();
		ArrayList<String> listOfTraversedURLs = new ArrayList<>();
		
		listOfPendingURLs.add(startingUrl);
		while(!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
			String urlString = listOfPendingURLs.remove(0);
			if(!listOfTraversedURLs.contains(urlString)) {
				listOfTraversedURLs.add(urlString);
				System.out.println("Crawl " +urlString);
				
				for(String s: getSubURLs(urlString)) {
					if(!listOfTraversedURLs.contains(s)) {
						listOfPendingURLs.add(s);
					}
				}
			}
		}
	}

	
	public static ArrayList<String> getSubURLs(String urlString){
		ArrayList<String> list = new ArrayList<>();
		try {
			URL url = new URL(urlString);
			Scanner scanner = new Scanner(url.openStream());
			int curruent = 0;
			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				curruent = line.indexOf("https:", curruent);
				while(curruent > 0) {
					int endIndex = line.indexOf("\"", curruent);
					if (endIndex > 0) {
						list.add(line.substring(curruent, endIndex));
						curruent = line.indexOf("https:", endIndex);
					}
					else {
						curruent = -1;
					}
				}
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

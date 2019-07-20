package com.practice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class WebCrawler {

	public static void main(String[] args) throws MalformedURLException, IOException {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a URL: ");
		String url = input.nextLine();
		crawler(url);
		input.close();
	}

	private static void crawler(String url) throws MalformedURLException, IOException {
		ArrayList<String> listOFPendingUrls = new ArrayList<String>();
		ArrayList<String> listOfTraversedURLs = new ArrayList<String>();

		listOFPendingUrls.add(url);
		while (!listOFPendingUrls.isEmpty() && listOfTraversedURLs.size() <= 100) {
			String urlString = listOFPendingUrls.remove(0);
			if (!listOfTraversedURLs.contains(urlString)) {
				listOfTraversedURLs.add(urlString);
				System.out.println("Crawl: " + urlString);

				for (String s : getSubURLS(urlString)) {
					if (!listOfTraversedURLs.contains(s)) {
						listOFPendingUrls.add(s);
					}
				}
			}
		}

	}

	private static ArrayList<String> getSubURLS(String urlString) throws IOException, MalformedURLException {
		ArrayList<String> list = new ArrayList<String>();
		URL url;
		url = new URL(urlString);
		Scanner input = new Scanner(url.openStream());
		int current = 0;
		while(input.hasNext()) {
			String line = input.nextLine();
			current = line.indexOf("http:", current);
			while(current > 0) {
				int endIndex = line.indexOf("\"",current);
				if(endIndex > 0) {
					list.add(line.substring(current, endIndex));
					current  = line.indexOf("http:", endIndex);
				}
				else {
					current -= 1;
				}
			}
		}
		input.close();
		return list;
	}

}

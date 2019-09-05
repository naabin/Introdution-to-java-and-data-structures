package com.week6.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ProcessCollectorFile {
	
	public static void main(String[] args) throws FileNotFoundException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("collectors.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("total.txt"));
			writer.write("Report was generated on " + new Date() + "\n");
			String nextLine = reader.readLine();
			System.out.println("Generting report .....");
			while(nextLine != null) {
				String[] splitStrings = nextLine.split(":");
				String name = splitStrings[0];
				String[] weights = splitStrings[1].split(",");
				Collector collector = new Collector(name, weights);
				writer.write(collector.calculateTotal() + "\n");
				nextLine = reader.readLine();
			}
			System.out.println("Report is ready");
			reader.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

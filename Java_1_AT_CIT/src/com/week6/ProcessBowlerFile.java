package com.week6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ProcessBowlerFile {
	
	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("bowler.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("averges.txt"));
			writer.write(new Date() + "\n");
			String nextLine = reader.readLine();
			while(nextLine != null) {
				String[] lineArray = nextLine.split(";");
				String name = lineArray[0];
				String[] bowlerScores = lineArray[1].split(",");
				Bowler player = new Bowler(name, bowlerScores);
				writer.write(player.calculateAverage() + "\n");
				nextLine = reader.readLine();
				
			}
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

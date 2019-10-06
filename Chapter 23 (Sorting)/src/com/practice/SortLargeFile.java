package com.practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class SortLargeFile {
	
	public static final int MAX_ARRAY_SIZE = 1000000;
	public static final int BUFFER_SIZE = 1000000;
	
	public static void main(String[] args) throws IOException {
		
		// Sort largedata.dat to sortedfile.dat
		sort("largedata.dat", "sortedfile.dat");
		
		//Display the first 100 numbers in the sorted file
		displayFile("sortedfile.dat");
		
	}
	
	



	private static void sort(String sourcefile, String targetfile) throws IOException {
		
		int numberOfSegments = SortLargeFile.initializeSegements(MAX_ARRAY_SIZE, sourcefile, "f1.dat");
		
		//Implement Phase 2: Merge segments recursively
		merge(numberOfSegments, MAX_ARRAY_SIZE, "f1.dat", "f2.dat", "f3.dat", targetfile);
		
	}
	
	private static void merge(int numberOfSegments, int segmentSize, String f1, String f2, String f3,
			String targetfile) throws IOException {
		if(numberOfSegments > 1) {
			mergeOneStep(numberOfSegments, segmentSize, f1, f2, f3);
			merge((numberOfSegments + 1)/2, segmentSize * 2, f3, f1, f2, targetfile);
			
		}
		else {
			File sortedFile = new File(targetfile);
			if(sortedFile.exists()) {
				sortedFile.delete();
				new File(f1).renameTo(sortedFile);
			}
		}
		
	}





	private static void mergeOneStep(int numberOfSegments, int segmentSize, String f1, String f2, String f3) throws IOException {
		DataInputStream f1Input = new DataInputStream(new BufferedInputStream(new FileInputStream(f1), BUFFER_SIZE));
		DataOutputStream f2Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f2), BUFFER_SIZE));
		
		copyHalfToF2(numberOfSegments, segmentSize, f1Input, f2Output);
		f2Output.close();
		
		//Merge remaining segments from f1 with segments in f2 into f3
		DataInputStream f2Input = new DataInputStream(new BufferedInputStream(new FileInputStream(f2), BUFFER_SIZE));
		DataOutputStream f3OutPut = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f3), BUFFER_SIZE));
		
		mergeSegments(numberOfSegments / 2, segmentSize, f1Input, f2Input, f3OutPut);
		
		f1Input.close();
		f2Input.close();
		f3OutPut.close();
	}





	private static void mergeSegments(int numberOfSegments, int segmentSize, DataInputStream f1Input, DataInputStream f2Input,
			DataOutputStream f3OutPut) throws IOException {
		for(int i = 0; i < numberOfSegments; i++) {
			mergeTwoSegments(segmentSize, f1Input, f2Input, f3OutPut);
		}
		
		while(f1Input.available() > 0) {
			f3OutPut.writeInt(f1Input.readInt());
		}
		
	}





	private static void mergeTwoSegments(int segmentSize, DataInputStream f1Input, DataInputStream f2Input,
			DataOutputStream f3OutPut) throws IOException {
		
		int intFromF1 = f1Input.readInt();
		int intFromF2 = f2Input.readInt();
		int f1Count = 1;
		int f2Count = 1;
		
		while(true) {
			if(intFromF1 < intFromF2) {
				f3OutPut.writeInt(intFromF1);
				
				if(f1Input.available() == 0 || f1Count++ >= segmentSize) {
					f3OutPut.writeInt(intFromF2);
					break;
				}
				else {
					intFromF1 = f1Input.readInt();
				}
			}
			else {
				f3OutPut.writeInt(intFromF2);
				if(f2Input.available() == 0 || f2Count++ >= segmentSize) {
					f3OutPut.writeInt(intFromF1);
					break;
				}
				else {
					intFromF2 = f2Input.readInt();
				}
			}
			
		}
		
		while(f1Input.available() > 0 && f1Count++ < segmentSize) {
			f3OutPut.writeInt(f1Input.readInt());
			
		}
		while(f2Input.available() > 0 && f2Count++ < segmentSize) {
			f3OutPut.writeInt(f2Input.readInt());
		}
	}





	private static void copyHalfToF2(int numberOfSegments, int segmentSize, DataInputStream f1Input,
			DataOutputStream f2Output) throws IOException {
		for(int i = 0; i < (numberOfSegments / 2) * segmentSize; i++) {
			f2Output.writeInt(f1Input.readInt());
		}
		
	}





	private static void displayFile(String sortedfile) {
		try {
			DataInputStream in = new DataInputStream(new FileInputStream(sortedfile));
			for(int i =0; i < 100; i++) {
				System.out.print(in.readInt() + " ");
				
			}
			in.close();
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static int initializeSegements(int segmentSize, String originalFile, String f1) throws IOException {
		int[] list = new int[segmentSize];
		
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(originalFile)));
		
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1)));
		
		int numberOfSegments  = 0;
		while(input.available() > 0) {
			numberOfSegments++;
			int i = 0;
			for( ; input.available() > 0 && i < segmentSize; i++) {
				list[i] = input.readInt();
			}
			//Sort an array list[0..i-1]
			Arrays.sort(list, 0, i);
			
			//write the array to f1.dat
			for(int j = 0; j < i; j++) {
				output.writeInt(list[j]);
			}
		}
		input.close();
		output.close();
		return numberOfSegments;
	}

}

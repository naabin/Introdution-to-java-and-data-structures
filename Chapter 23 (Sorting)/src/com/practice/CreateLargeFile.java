package com.practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateLargeFile {

	public static void main(String[] args) throws IOException {
		DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("largedata.dat")));
		
		for(int i = 0; i < 2_000_000; i++) {
			output.writeInt((int) (Math.random() * 1000000));
		}
		
		output.close();
		
		DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("largedata.dat")));
		
		for(int i = 0; i < 100; i++) {
			System.out.print(input.readInt() + " ");
		}
		input.close();
	}
}

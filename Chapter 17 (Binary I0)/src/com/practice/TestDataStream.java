package com.practice;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream {
	
	public static void main(String[] args) throws IOException {
		DataOutputStream out = new DataOutputStream(new FileOutputStream("temp1.dat"));
		out.writeUTF("John");
		out.writeDouble(85.5);
		out.writeUTF("Jim");
		out.writeDouble(185.5);
		out.writeUTF("George");
		out.writeDouble(105.25);
		
		
		DataInputStream input = new DataInputStream(new FileInputStream("temp1.dat"));
		
		
		System.out.println(input.readUTF() + " " + input.readDouble());
		System.out.println(input.readUTF() + " " + input.readDouble());
		System.out.println(input.readUTF() + " " + input.readDouble());
		
		out.close();
		input.close();
		
		
	}

}

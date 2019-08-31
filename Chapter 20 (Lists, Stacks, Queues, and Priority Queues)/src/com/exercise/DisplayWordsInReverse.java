package com.exercise;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Stack;

public class DisplayWordsInReverse {
	
	public static void main(String[] args) throws IOException {
		
		DataOutputStream o = new DataOutputStream(new FileOutputStream("words.txt"));
		
		o.writeUTF("Java Programming is awesome.");
		
		o.close();
		
		
		DataInputStream inputStream = new DataInputStream(new FileInputStream("words.txt"));
		
		Stack<String> strings = new Stack<String>();
		
		String words = inputStream.readUTF();
		
		for(int i = 0, length = words.length(); i < length; i++) {
			strings.add(Character.toString(words.charAt(i)));
		}
		
		String reversedWords = "";
		for(int i = 0, length = strings.size(); i < length; i++) {
			reversedWords +=  strings.pop() + " ";
		}
		
		System.out.println(reversedWords);
		inputStream.close();
	}
}

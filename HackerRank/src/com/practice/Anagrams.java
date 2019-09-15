package com.practice;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		
		in.close();
		boolean ret = false;
		String w1 = sortedWord(a);
		String w2 = sortedWord(b);
		if(w1.length() != w2.length()) {
			ret = false;
		}
		if(w1.equals(w2)) {
			ret = true;
		}
		
		System.out.println(ret ? "Anagrams" : "Not Anagrams");
		System.out.println(sortedWord(a));
		System.out.println(sortedWord(b));
		
	}
	
	public static boolean isAnagram1(String a, String b) {
		char[] charArray = a.toCharArray();
		char[] charArray2 = b.toCharArray();
		Arrays.sort(charArray);
		Arrays.sort(charArray2);
		
		return charArray.equals(charArray2);
	}
	
	public static String sortedWord(String a) {
		a.toLowerCase();
		char[] charArray = a.toCharArray();
		int index = 0;
		for(int i = 'a'; i<='z'; i++) {
			for(int j = 0; j < a.length(); j++) {
				if(a.charAt(j) == i) {
					charArray[index++]=(char)(i);
				}
			}
		}
		return new String(charArray);
	}
	
	public static boolean isAnagram(String a, String b) {
		b.toLowerCase();
		a.toLowerCase();
		boolean isAnagram = false;
		if(a.length() != b.length()) {
			isAnagram = false;
		}
		Map<Character , Integer> letterCount = new HashMap<Character, Integer>();
		for(int i = 0; i < a.length(); i++) {
			if(letterCount.containsKey(a.charAt(i))) {
				Integer value = letterCount.get(a.charAt(i));
				value += 1;
				letterCount.put(a.charAt(i), value);
				
			}
			else {
				letterCount.put(a.charAt(i), 1);
			}
		}
		Map<Character, Integer> letterCount2 = new HashMap<Character, Integer>();
		for(int i = 0; i < b.length(); i++) {
			if(letterCount2.containsKey(b.charAt(i))) {
				Integer value = letterCount2.get(b.charAt(i));
				value += 1;
				letterCount2.put(b.charAt(i), value);
			}
			else {
				letterCount2.put(b.charAt(i), 1);
			}
		}
		if(letterCount.equals(letterCount2)) {
			isAnagram = true;
		}
		return isAnagram;
	}

}

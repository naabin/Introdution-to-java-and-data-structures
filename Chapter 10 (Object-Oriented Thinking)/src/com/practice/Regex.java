package com.practice;

public class Regex {

	public static void main(String[] args) {
		System.out.println("Java is fun".matches("Java.*"));
		System.out.println("440-02-4534".matches("\\d{3}-\\d{2}-\\d{4}"));
		
		String string = "a+b$#c".replaceAll("[$+#]", "NNN");
		System.out.println(string);
		
		String[] strings = "Java,C?C#,C++".split("[.,:;?]");
		
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
	}

}

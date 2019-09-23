package com.sololearn;

import java.util.Scanner;

public class CaesarCipher {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String message = in.nextLine();
		String shiftedMessage = "";
		char[] charArray = message.toCharArray();
		for(int i = 0; i < charArray.length; i++) {
			if(charArray[i] == ' ') {
				shiftedMessage += " ";
			}
			else if(Character.isUpperCase(charArray[i])) {
				char ch = (char)((charArray[i] + 1 - 'A') % 26 + 'A');
				shiftedMessage += ch;
			}
			else {
				char ch = (char)((int)(charArray[i] + 1 - 'a') % 26 + 'a');
				shiftedMessage += ch;
			}
		}
		System.out.println("Encoded message for "+ message + " is\n=> " + shiftedMessage);
		in.close();
	}

}

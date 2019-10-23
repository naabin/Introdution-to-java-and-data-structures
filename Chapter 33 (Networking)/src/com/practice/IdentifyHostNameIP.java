package com.practice;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class IdentifyHostNameIP {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter url: ");
		while(true) {
			try {
				String url = in.nextLine();
				InetAddress address = InetAddress.getByName(url);
				System.out.println("Host name: " + address.getHostName());
				System.out.println("IP address: " + address.getHostAddress());
				System.out.println("Cannonical address: " + address.getHostName());
				
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		
	}

}

package com.practice;

import java.security.Permission;
import java.util.Scanner;

public class IntToString {
	
	public static void main(String[] args) {
		
		DoNotTerminate.forbidExit();
		
		try {
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			in.close();
			
			String s = Integer.toString(n);
			System.out.println(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
class DoNotTerminate {
	public static class ExitTrappedException extends SecurityException {
		private static final long serialVersionUID = 1L;
		
	}
	
	public static void forbidExit() {
		final SecurityManager securityManager = new SecurityManager() {
			@Override
			public void checkPermission(Permission permission) {
				if(permission.getName().contains("exitVm")) {
					throw new ExitTrappedException();
				}
			}
		};
		System.setSecurityManager(securityManager);
	}
}

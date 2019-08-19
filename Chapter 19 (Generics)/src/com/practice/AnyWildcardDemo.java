package com.practice;

public class AnyWildcardDemo {
	
	public static void main(String[] args) {
		GenericStack<Integer> intStack = new GenericStack<Integer>();
		
		for(int i = 0; i <= 10; i++) {
			intStack.push(i);
		}
		
		print(intStack);
	}
	
	public static void print(GenericStack<?> stack) {
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

}

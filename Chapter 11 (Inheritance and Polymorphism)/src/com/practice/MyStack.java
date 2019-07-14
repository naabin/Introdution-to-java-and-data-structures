package com.practice;

import java.util.ArrayList;

public class MyStack {
	
	private ArrayList<Object> list = new ArrayList<Object>();
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int getSize() {
		return list.size();
	}
	
	public Object peek() {
		return list.get(getSize() - 1);
	}
	
	public Object pop() {
		Object o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
	
	public void push(Object o) {
		list.add(o);
	}
	
	@Override
	public String toString() {
		return "stack: " + list.toString();
	}
	
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		for(int i = 0; i < 11; i++) {
			myStack.push(i);
		}
		System.out.println(myStack);
		System.out.println("Size of the stack: " + myStack.getSize());
		System.out.println("Stack peek: " + myStack.peek());
		System.out.println("Stack pop: " + myStack.pop());
		System.out.println("Stack empty?: " + myStack.isEmpty());
	}

}

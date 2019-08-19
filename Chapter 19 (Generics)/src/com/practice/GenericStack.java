package com.practice;

import java.util.ArrayList;

public class GenericStack<E> {
	private ArrayList<E> list = new ArrayList<E>();
	
	
	public int getSize() {
		return list.size();
	}
	
	public E peek() {
		return list.get(getSize() - 1);
	}
	
	public void push(E o) {
		list.add(o);
	}
	
	public E pop() {
		E o = list.get(getSize() - 1);
		list.remove(getSize() - 1);
		return o;
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	@Override
	public String toString() {
		return "Stack: " + list.toString(); 
	}
	
	public static void main(String[] args) {
		GenericStack<String> stack = new GenericStack<>();
		stack.push("London");
		stack.push("Paris");
		stack.push("Berlin");
		stack.push("New York");
		
		System.out.println(stack);
		
	}
}

package com.practice;

public class StackOfIntegers {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 16;
	
	/**
	 * Construct a stack with the default capacity
	 */
	public StackOfIntegers() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * Construct a stack with the specified maximum capacity
	 * @param capacity
	 */
	public StackOfIntegers(int capacity) {
		this.elements = new int[capacity];
	}
	/**
	 * Push a new integer to the top of the stack
	 * @param value
	 */
	public void push(int value) {
		if(size >= elements.length) {
			int [] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}
		elements[size++] = value;
	}
	
	/**
	 * 
	 * @return and remove the top element from the stack
	 */
	public int pop() {
		return elements[--size];
	}
	/**
	 * 
	 * @return the top element from the stack
	 */
	public int peek() {
		return elements[size - 1];
	}
	/**
	 * 
	 * @return Test whether the stack is empty
	 */
	public boolean empty() {
		return size == 0;
	}
	/**
	 * 
	 * @return the number of elements in the stack
	 */
	public int getSize() {
		return size;
	}
	
	public static void main(String[] args) {
		StackOfIntegers stack = new StackOfIntegers();
		for(int i = 0; i < 20; i++) {
			stack.push(i);
		}
		while(!stack.empty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}

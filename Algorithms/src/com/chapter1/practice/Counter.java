package com.chapter1.practice;

public class Counter {
	private final String name;
	private int count = 0;
	
	public Counter(String id) {
		this.name = id;
	}
	
	public void increment() {
		count++;
	}
	
	public int tally() {
		return count;
	}
	
	@Override
	public String toString() {
		return count + " " + name;
	}
	
	@Override
	public boolean equals(Object x) {
		if(this == x) {
			return true;
		}
		if(x == null) {
			return false;
		}
		if(this.getClass() != x.getClass()) {
			return false;
		}
		Counter that = (Counter)x;
		if(this.count != that.count) {
			return false;
		}
		if(this.name != that.name) {
			return false;
		}
		return true;
	}
}


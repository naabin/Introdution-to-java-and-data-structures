package com.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		//Submit runnable tasks to the executor
		TaskThreadDemo demo = new TaskThreadDemo();
		executor.execute(demo.new PrintChar('a', 100));
		executor.execute(demo.new PrintChar('b', 100));
		executor.execute(demo.new PrintNum(100));
		
		//Shut down the executor
		executor.shutdown();
		
	}

}

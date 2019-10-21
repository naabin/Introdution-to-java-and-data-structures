package com.practice;



public class TaskThreadDemo {

	public static void main(String[] args) {
		
		//Create a tasks
		TaskThreadDemo outer = new TaskThreadDemo();
		TaskThreadDemo.PrintChar inner = outer.new PrintChar('a', 1000);
		TaskThreadDemo.PrintChar inner2 = outer.new PrintChar('b', 1000);
		TaskThreadDemo.PrintNum inner3 = outer.new PrintNum(1000);
		
		
		//Create threads
		Thread thread1 = new Thread(inner);
		Thread thread2 = new Thread(inner2);
		Thread thread3 = new Thread(inner3);
		
		//Start threads
		thread1.start();
		System.out.println(thread1.isAlive());
		thread2.start();
		System.out.println(thread2.isAlive());
		thread3.start();
		System.out.println(thread3.isAlive());
		System.out.println(thread1.isAlive());
		
	}

	public class PrintChar implements Runnable {

		private char charToPrint;
		private int times;

		public PrintChar(char c, int t) {
			this.charToPrint = c;
			this.times = t;
		}

		@Override
		public void run() {

			for (int i = 0; i < this.times; i++) {
				System.out.print(this.charToPrint);
			}
			System.out.println();
		}

	}
	
	public class PrintNum implements Runnable {
		
		private int lastNum;
		
		public PrintNum(int n) {
			this.lastNum = n;
		}

		@Override
		public void run() {
			
			for(int i = 0; i <= this.lastNum; i++) {
				System.out.print(" " + i);
			}
			System.out.println();
			
		}
		
	}

}

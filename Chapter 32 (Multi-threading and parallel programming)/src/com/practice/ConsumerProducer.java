package com.practice;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducer {
	
	private static Buffer buffer = new Buffer();
	
	public static void main(String[] args) {
		//Create a thread pool with two threads
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		
		executor.shutdown();
	}
	
	//A task for adding an int to the buffer
	private static class ProducerTask implements Runnable{

		@Override
		public void run() {
			try {
				int i = 1;
				while(true) {
					System.out.println("Producer writes " + i);
					buffer.write(i++);
					//Put the thread into sleep
					Thread.sleep((int)(Math.random() * 10000));
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	//A task for reading and deleting an int from the buffer
	private static class ConsumerTask implements Runnable{

		@Override
		public void run() {
			try {
				while(true) {
					System.out.println("\t\t\tConsumer reads " + buffer.read());
					//Put the thread into sleep
					Thread.sleep((int)(Math.random() * 10000));
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public static class Buffer {
		private static final int CAPACITY = 1; // buffer size
		private LinkedList<Integer> queue = new LinkedList<Integer>();

		// Create a new lock
		private static Lock lock = new ReentrantLock();

		// Create two conditions
		private static Condition notEmpty = lock.newCondition();
		private static Condition notFull = lock.newCondition();

		public void write(int value) {
			lock.lock();
			try {
				while (this.queue.size() == Buffer.CAPACITY) {
					System.out.println("Wait for notFull condition");
					notFull.await();
				}
				this.queue.offer(value);
				notEmpty.signal();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}

		public int read() {
			int value = 0;
			lock.lock();
			try {
				while (this.queue.isEmpty()) {
					System.out.println("\t\t\tWait for notEmpty condtion");
					notEmpty.await();
				}
				value = this.queue.remove();
				notFull.signal();
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
			finally{
				lock.unlock();
			}
			return value;
		}
	}

}

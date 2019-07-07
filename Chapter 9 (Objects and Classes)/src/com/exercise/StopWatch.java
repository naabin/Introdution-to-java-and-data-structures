package com.exercise;

public class StopWatch {
	private long startTime;
	private long endTime;
	
	public StopWatch() {
		startTime = System.currentTimeMillis();
	}

	public long getStartTime() {
		return startTime;
	}

	public long getEndtime() {
		return endTime;
	}
	
	public void start() {
		startTime = System.currentTimeMillis();
	}
	public void stop() {
		endTime = System.currentTimeMillis();
	}
	public long getElapsedTime() {
		return endTime - startTime;
	}
	public static void main(String[] args) {
		int[] arrays = new int[10000];
		for(int i =0; i < arrays.length; i++) {
			arrays[i] = (int)(Math.random() * arrays.length);
		}
		System.out.print("Unsorted Arrays: [");
		for(int i = 0; i < arrays.length; i++) {
			if((i + 1) % 20 == 0){
				System.out.println(arrays[i]);
			}
			else {
				System.out.print(arrays[i] +", ");
			}
		}
		System.out.print("]");
		System.out.println("\n\n");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		System.out.println("Sorted Arrays:");
		System.out.print("[");
		int[] selectionSort = selectionSort(arrays);
		for(int i = 0; i < selectionSort.length; i++) {
			if((i +1)% 20 == 0) {
				System.out.println(selectionSort[i]);
			}
			else {
				System.out.print(selectionSort[i] + ", ");
			}
		}
		System.out.println("]");
		stopWatch.stop();
		long elapsedTime = stopWatch.getElapsedTime();
		System.out.println("Execution time for sorting and displays selection sort " + elapsedTime + " milliseconds");
		
	}
	public static int[] selectionSort(int[] arrays) {
		int[] sortedArrays = arrays;
		for(int i = 0; i < arrays.length; i++) {
			int smallestElement = sortedArrays[i];
			int currentMinIndex = i;
			
			for(int j = i + 1; j < arrays.length; j++) {
				if(smallestElement > arrays[j]) {
					smallestElement = arrays[j];
					currentMinIndex = j;
				}
				
			}
			if(currentMinIndex != i) {
				sortedArrays[currentMinIndex] = sortedArrays[i];
				sortedArrays[i] = smallestElement;
			}
		}
		return sortedArrays;
	}
}

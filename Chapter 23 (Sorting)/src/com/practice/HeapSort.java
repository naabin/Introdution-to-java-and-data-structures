package com.practice;

import java.util.Arrays;

public class HeapSort {
	
	public static <E extends Comparable<E>> void heapSort(E[] list) {
		//Create a heap of type e
		Heap<E> heap = new Heap<>();
		
		for(int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}
		
		for(int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.remove();
		}
	}
	
	public static void main(String[] args) {
		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
		
		heapSort(list);
		System.out.println(Arrays.toString(list));
	}

}

package com.practice;

public class RecursiveSelectionSort {
	
	
	public void sort(double[] list) {
		sort(list, 0, list.length-1);
	}

	private void sort(double[] list, int low, int high) {
		if(low < high) {
			int indexOfMin = low;
			double min = list[low];
			
			for(int i = low + 1; i <= high; i++) {
				if(list[i] < min) {
					min = list[i];
					indexOfMin = i;
				}
			}
			
			//Swap the smallest in the list[low ... high] with list[low]
			list[indexOfMin] = list[low];
			list[low] = min;
			
			sort(list, low + 1, high);
		}
	}

}

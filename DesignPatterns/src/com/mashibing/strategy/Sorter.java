package com.mashibing.strategy;

public class Sorter {

	public static void sort(int[] arr) {
		
		for (int i = 0; i < arr.length-1; i++) {
			int minpos = i;
			for (int j = i+1; j < arr.length; j++) {
				minpos = arr[j] < arr[minpos] ? j : minpos;
			}
			swap(arr, i, minpos);
		}
		
	}
	
	static void swap(int[] arr,int i ,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

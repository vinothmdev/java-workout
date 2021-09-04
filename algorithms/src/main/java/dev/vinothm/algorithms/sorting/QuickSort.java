package dev.vinothm.algorithms.sorting;

public class QuickSort {

	public void sort(int[] arr, int start, int end) {
		if (start < end) {
			int pivot = partition(arr, start, end);
			sort(arr, start, pivot - 1);
			sort(arr, pivot + 1, end);
		}
	}

	private int partition(int[] arr, int start, int end) {
		int x = arr[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (arr[j] <= x) {
				int temp = arr[++i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[++i];
		arr[i] = arr[end];
		arr[end] = temp;
		return i;
	}

}

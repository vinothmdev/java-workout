package dev.vinothm.algorithms.sorting;

public class QuickSort {

    public void sort(int[] arr, int start, int end) {
	if (start < end) {
	    int pivot = partition(arr, start, end);
	    sort(arr, start, pivot - 1);
	    sort(arr, pivot + 1, end);
	}
    }

    public void reverseSort(int[] arr, int start, int end) {
	if (start < end) {
	    int pivot = reversePartition(arr, start, end);
	    reverseSort(arr, start, pivot - 1);
	    reverseSort(arr, pivot + 1, end);
	}
    }

    private int reversePartition(int[] arr, int start, int end) {
	int x = arr[end];
	int i = start - 1;
	for (int j = start; j < end; j++) {
	    if (arr[j] >= x) {
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

    public int partition2(int[] arr, int start, int end) {
	int x = arr[end];
	int i = start - 1;
	int k = start - 1;
	for (int j = start; j < end; j++) {
	    if (arr[j] < x) {
		int temp = arr[++i];
		arr[i] = arr[j];
		arr[j] = temp;
		k++;
	    } else if (arr[j] == x) {
		k++;
	    }
	}
	int temp = arr[++k];
	arr[k] = arr[end];
	arr[end] = temp;
	return (i + k) / 2 + 1;
    }

}

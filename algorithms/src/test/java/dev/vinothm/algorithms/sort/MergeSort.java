package dev.vinothm.algorithms.sort;

public class MergeSort {

    public void merge(int[] arr, int p, int q, int r) {
	int i = 0;
	int[] left = new int[q - p + 1];
	while (i < left.length)
	    left[i] = arr[p + i++];
	i = 0;
	int[] right = new int[r - q];
	while (i < right.length)
	    right[i] = arr[q + 1 + i++];
	i = p;
	int j = 0;
	int k = 0;
	while (k < right.length && j < left.length) {
	    if (left[j] <= right[k])
		arr[i++] = left[j++];
	    else
		arr[i++] = right[k++];
	}
	while (k < right.length)
	    arr[i++] = right[k++];
	while (j < left.length)
	    arr[i++] = left[j++];
	for (int x : arr)
	    System.out.print(x);
	System.out.println();
    }

    public void mergeSort(int[] arr, int start, int end) {
	if (start < end) {
	    int mid = (end + start) / 2;
	    mergeSort(arr, start, mid);
	    mergeSort(arr, mid + 1, end);
	    merge(arr, start, mid, end);
	}
    }

    public static void main(String[] args) {
	new MergeSort().mergeSort(new int[] { 5, 4, 3, 2, 1 }, 0, 4);
    }

}

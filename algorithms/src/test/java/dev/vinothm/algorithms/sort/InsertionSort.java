package dev.vinothm.algorithms.sort;

public class InsertionSort {

    public void sort(int[] arr) {
	for (int i = 1; i < arr.length; i++) {
	    int k = arr[i];
	    int j = i - 1;
	    while (j >= 0 && arr[j] > k) {
		arr[j + 1] = arr[j--];
	    }
	    arr[j + 1] = k;
	}
    }

    public static void main(String[] args) {
	int[] arr = new int[] { 5, 4, 3, 2, 1 };
	new InsertionSort().sort(arr);
	for (int i : arr)
	    System.out.print(i);
	System.out.println();
    }

}

package dev.vinothm.algorithms.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InsertionSort {

    public void sort(int[] arr) {
	int count = 0;
	for (int i = 1; i < arr.length; i++) {
	    var hold = arr[i];
	    int j = i - 1;
	    for (; j >= 0 && arr[j] > hold; j--) {
		arr[j + 1] = arr[j];
		count++;
	    }
	    System.out.print(count);
	    arr[j + 1] = hold;
	}
    }

    public int getInvCount(int[] arr) {
	int inv_count = 0;
	for (int i = 0; i < arr.length - 1; i++)
	    for (int j = i + 1; j < arr.length; j++)
		if (arr[i] > arr[j])
		    inv_count++;

	return inv_count;
    }

    public int getInvCount_two(int[] arr) {
	int[] original = Arrays.copyOf(arr, arr.length);
	Arrays.sort(arr);
	int count = 0;
	for (int i = 0; i < arr.length; i++) {
	    var index = Arrays.binarySearch(original, arr[i]);
	    count += Math.abs(i - index);
	}
	return count / 2;
    }

    public int search(int[] arr, int start, int end, int key) {
	if (start > end)
	    return -1;
	var middle = start + (end - start) / 2;
	if (arr[middle] == key)
	    return middle;
	if (arr[middle] > key)
	    return search(arr, 0, middle, key);
	return search(arr, middle, end, key);
    }

    public int insertionSort(List<Integer> arr) {
	// Write your code here
	var sorted = arr.stream().sorted().collect(Collectors.toList());
	int count = 0;
	for (int i = 0; i < arr.size(); i++) {
	    if (arr.get(i) != sorted.get(i)) {
		var index = Collections.binarySearch(arr, sorted.get(i));
		count += Math.abs(Math.abs(index) - i);
	    }
	}
	return count / 2;
    }

    public static void main(String[] args) {
	var input = new int[] { 4, 3, 2, 1 };
	long startTime = System.nanoTime();
	System.out.println(new InsertionSort().getInvCount(input));
	long stopTime = System.nanoTime();
	long first = stopTime - startTime;
	startTime = System.nanoTime();
	System.out.println(new InsertionSort().getInvCount_two(input));
	stopTime = System.nanoTime();
	long second = stopTime - startTime;
	System.out.println(first - second);
	System.out.print(new InsertionSort().insertionSort(List.of(3, 5, 7, 11, 9)));
    }

}

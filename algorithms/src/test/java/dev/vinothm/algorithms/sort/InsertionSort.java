package dev.vinothm.algorithms.sort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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

    public void binsort(int[] arr) {
	LinkedList<Integer> list = new LinkedList<>();
	int count = 0;
	list.add(arr[0]);
	for (int i = 1; i < arr.length; i++) {
	    var index = indexToInsert(list, arr[i]);
	    if (index < 0 || list.get(index) != arr[i]) {
		count += index > 0 ? list.size() - index : list.size() - index + 1;
		list.add(index > 0 ? index : -1 * (index + 1), arr[i]);
	    }
	}
	System.out.println(count);
	for (int i : list)
	    System.out.print(i);
    }

    public int indexToInsert(List<Integer> list, int key) {
	return Collections.binarySearch(list, key);
    }

    public static void main(String[] args) {
	int[] arr = new int[] { 2, 1, 3, 1, 2 };
	new InsertionSort().sort(arr);
	for (int i : arr)
	    System.out.print(i);
	System.out.println();
	arr = new int[] { 2, 1, 3, 1, 2 };
	new InsertionSort().binsort(arr);
    }

}

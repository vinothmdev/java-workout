package dev.vinothm.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfInversions {

	public int merge(List<Integer> arr, int start, int middle, int end) {
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();
		for (int i = start; i <= middle; i++) {
			left.add(arr.get(i));
		}
		for (int i = middle + 1; i <= end; i++) {
			right.add(arr.get(i));
		}

		int i = 0;
		int j = 0;
		int k = start;
		int count = 0;
		while (i < left.size() && j < right.size()) {
			if (left.get(i) <= right.get(j)) {
				arr.set(k++, left.get(i++));
			} else {
				arr.set(k++, right.get(j++));
				count += (middle + 1) - (start + i);
			}
		}
		while (i < left.size()) {
			arr.set(k++, left.get(i++));
		}
		while (j < right.size()) {
			arr.set(k++, right.get(j++));
		}
		return count;
	}

	public int mergeSort(List<Integer> arr, int start, int end) {
		int count = 0;
		if (start < end) {
			int middle = start + (end - start) / 2;
			count += mergeSort(arr, start, middle);
			count += mergeSort(arr, middle + 1, end);
			count += merge(arr, start, middle, end);
		}
		return count;
	}

	public static void main(String[] args) {
		var list = Arrays.asList(2, 1, 3, 1, 2);
		int count = new NumberOfInversions().mergeSort(list, 0, list.size() - 1);
		System.out.println(count);
	}
}

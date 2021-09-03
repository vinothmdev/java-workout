package dev.vinothm.algorithms.sorting;

import dev.vinothm.algorithms.heap.MaxHeap;

public class HeapSort {

	public void sort(int[] arr) {
		var maxHeap = new MaxHeap(arr);
		maxHeap.build(arr);
		for (var i = arr.length - 1; i > 0; i--) {
			var temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeap.heapify(arr, i, 0);
		}

	}

}

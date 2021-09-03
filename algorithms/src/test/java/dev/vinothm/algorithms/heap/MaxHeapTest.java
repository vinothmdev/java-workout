package dev.vinothm.algorithms.heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MaxHeapTest {

	MaxHeap maxHeap = new MaxHeap(new int[] { 16, 14, 10, 4, 7, 9, 3, 2, 8, 1 });

	@Test
	void hepifyTest() {
		maxHeap.heapify(3);
		assertArrayEquals(maxHeap.value, new int[] { 16, 14, 10, 8, 7, 9, 3, 2, 4, 1 });
	}

	@Test
	void build() {
		int[] arr = new int[] { 1, 8, 2, 3, 9, 7, 4, 10, 14, 16 };
		maxHeap.build(arr);
		assertArrayEquals(new int[] { 16, 14, 7, 10, 9, 2, 4, 1, 3, 8 }, arr);
	}

}
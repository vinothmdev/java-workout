package dev.vinothm.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class HeapSortTest {

	@Test
	void test() {
		HeapSort heap = new HeapSort();
		int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		heap.sort(arr);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, arr);
	}

}

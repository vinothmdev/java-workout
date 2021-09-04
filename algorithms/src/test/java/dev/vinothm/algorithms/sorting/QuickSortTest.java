package dev.vinothm.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class QuickSortTest {

	@Test
	void testSort() {
		int[] arr = new int[] { 6, 5, 4, 3, 2, 1 };
		new QuickSort().sort(arr, 0, arr.length - 1);
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6 }, arr);

		arr = new int[] { 6, 5, -4, -3, 2, 1 };
		new QuickSort().sort(arr, 0, arr.length - 1);
		assertArrayEquals(new int[] { -4, -3, 1, 2, 5, 6 }, arr);

		arr = new int[] { 13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11 };
		new QuickSort().sort(arr, 0, arr.length - 1);
		assertArrayEquals(new int[] { 2, 4, 5, 6, 7, 8, 9, 11, 12, 13, 19, 21 }, arr);
	}

}

package dev.vinothm.algorithms.heap;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MaxPriorityQueueTest {
	@Test
	public void testExtractMax() {
		MaxPriorityQueue queue = new MaxPriorityQueue(new int[] { 16, 14, 10, 4, 7, 9, 3, 2, 8, 1 });
		try {
			assertEquals(16, queue.extractMax());
			assertEquals(9, queue.getQueueSize());
			assertEquals(14, queue.extractMax());
			assertEquals(8, queue.getQueueSize());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void increaseKey() {
		MaxPriorityQueue queue = new MaxPriorityQueue(new int[] { 16, 14, 10, 4, 7, 9, 3, 2, 8, 1 });
		try {
			queue.increaseKey(9, 15);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertArrayEquals(new int[] { 16, 15, 10, 8, 14, 9, 3, 2, 4, 7 }, queue.getQueueValue());
	}

	@Test
	public void insert() {
		MaxPriorityQueue queue = new MaxPriorityQueue(new int[] { 16, 14, 10, 4, 7, 9, 3, 2, 8, 1 });
		try {
			queue.insert(100);
			assertEquals(100, queue.extractMax());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
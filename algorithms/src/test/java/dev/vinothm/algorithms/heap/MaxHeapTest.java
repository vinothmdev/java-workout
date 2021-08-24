package dev.vinothm.algorithms.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class MaxHeapTest {

	@Test
	void isMaxHeapTest() {
		assertEquals(MaxHeap.isMaxHeap(List.of(16,14,10,8,7,9,3,2,4,1)), true);
		assertEquals(MaxHeap.isMaxHeap(List.of(16,14,10,8,7,9,3,2,4,10)), false);
	}

}
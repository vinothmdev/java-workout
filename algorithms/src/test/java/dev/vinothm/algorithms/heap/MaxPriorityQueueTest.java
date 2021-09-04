package dev.vinothm.algorithms.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MaxPriorityQueueTest {
    MaxPriorityQueue queue = new MaxPriorityQueue(new int[] { 16, 14, 10, 4, 7, 9, 3, 2, 8, 1 });

    @Test
    public void testExtractMax() {
        try {
            assertEquals(16, this.queue.extractMax());
            assertEquals(9, this.queue.getQueueSize());
            assertEquals(14, this.queue.extractMax());
            assertEquals(8, this.queue.getQueueSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void increaseKey(int i, int key) throws Exception {
        this.queue.increaseKey(6, 15);
        assertArrayEquals(new int[] { 15, 4, 7, 9, 3, 2, 8, 1 }, this.queue.getQueueValue());
    }
}
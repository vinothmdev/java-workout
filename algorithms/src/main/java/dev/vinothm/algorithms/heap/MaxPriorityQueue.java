package dev.vinothm.algorithms.heap;

import java.util.Arrays;

class MaxPriorityQueue {
    MaxHeap queue;

    public MaxPriorityQueue(int size) {
        this.queue = new MaxHeap(new int[size]);
    }

    public MaxPriorityQueue(int[] arr) {
        this.queue = new MaxHeap(arr);
    }

    public int getQueueSize() {
        return this.queue.value.length;
    }

    public int[] getQueueValue() {
        return this.queue.value;
    }

    public int getMax() {
        return this.queue.value[0];
    }

    public int extractMax() throws Exception {
        if (this.queue.value.length == 0) {
            throw new Exception("Queue underflow");
        }
        int max = this.queue.value[0];
        this.queue.value = Arrays.copyOfRange(this.queue.value, 1,this.queue.value.length);
        return max;
    }

    public void increaseKey(int i, int key) throws Exception {
        // if (this.queue.value[i] > key) {
        //     throw new Exception("Current value more than key");
        // }

        this.queue.value[i] = key;
        int p = this.queue.getParentOf(i);
        // while(i > 0
        //     && this.queue.value[i] > this.queue.value[p]) {
        //         int temp = this.queue.value[i];
        //         this.queue.value[i] = this.queue.value[p];
        //         this.queue.value[i] = temp;
        //         i = p;
        //         p = this.queue.getParentOf(i);
        // }
    }

}
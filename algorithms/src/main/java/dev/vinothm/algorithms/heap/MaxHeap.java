package dev.vinothm.algorithms.heap;

public class MaxHeap {
	int[] value;

	public MaxHeap(int[] value) {
		this.value = value;
		this.build();
	}

	public int getParentOf(int index) {
		return (index - 1) / 2;
	}

	public int getLeftOf(int index) {
		return 2 * index + 1;
	}

	public int getRightOf(int index) {
		return 2 * index + 2;
	}

	public void heapify(int at) {
		int left = this.getLeftOf(at);
		int right = this.getRightOf(at);
		int largest = left < this.value.length && this.value[left] > this.value[at] ? left : at;
		largest = right < this.value.length && this.value[right] > this.value[largest] ? right : largest;
		if (largest != at) {
			int temp = this.value[at];
			this.value[at] = this.value[largest];
			this.value[largest] = temp;
			this.heapify(largest);
		}

	}

	public void heapify(int[] arr, int at) {
		int left = this.getLeftOf(at);
		int right = this.getRightOf(at);
		int largest = left < arr.length && arr[left] > arr[at] ? left : at;
		largest = right < arr.length && arr[right] > arr[largest] ? right : largest;
		if (largest != at) {
			int temp = arr[at];
			arr[at] = arr[largest];
			arr[largest] = temp;
			this.heapify(arr, largest);
		}

	}

	public void heapify(int[] arr, int length, int at) {
		int left = this.getLeftOf(at);
		int right = this.getRightOf(at);
		int largest = left < length && arr[left] > arr[at] ? left : at;
		largest = right < length && arr[right] > arr[largest] ? right : largest;
		if (largest != at) {
			int temp = arr[at];
			arr[at] = arr[largest];
			arr[largest] = temp;
			this.heapify(arr, length, largest);
		}

	}

	public int[] build(int[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			this.heapify(arr, i);
		}
		return arr;
	}

	public int[] build() {
		for (int i = this.value.length / 2 - 1; i >= 0; i--) {
			this.heapify(this.value, i);
		}
		return this.value;
	}

}
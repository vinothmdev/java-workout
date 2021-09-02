package dev.vinothm.algorithms.sorting;

public class BubbleSort {

	public void sort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {
					var temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		var arr = new int[] { 5, 4, 3, 2, 1 };
		new BubbleSort().sort(arr);
		for (int x : arr)
			System.out.print(x + " ");
	}

}

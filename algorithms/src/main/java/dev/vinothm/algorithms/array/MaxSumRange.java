package dev.vinothm.algorithms.array;

public class MaxSumRange {

	private int max(int... args) {
		int max = args[0];
		for (int x : args)
			if (x > max)
				max = x;
		return max;
	}

	private int findMaxCrossingWindow(int[] arr, int s, int m, int e) {
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = m; i >= s; i--) {
			sum += arr[i];
			if (sum > leftSum) {
				leftSum = sum;
			}
		}

		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		for (int i = m + 1; i <= e; i++) {
			sum += arr[i];
			if (sum > rightSum) {
				rightSum = sum;
			}
		}

		return max(rightSum + leftSum, leftSum, rightSum);
	}

	public int findMaxSum(int[] arr, int s, int e) {
		if (s == e)
			return arr[e];
		int m = s + (e - s) / 2;
		int leftSum = findMaxSum(arr, s, m);
		int rightSum = findMaxSum(arr, m + 1, e);
		int crossSum = findMaxCrossingWindow(arr, s, m, e);
		return max(rightSum, leftSum, crossSum);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { -13, -3, -25, -20, -3, 16, -23, -18, -20, -7, -12, -5, -22, -15, -4, -7 };
		int sum = new MaxSumRange().findMaxSum(arr, 0, arr.length - 1);
		System.out.println(sum);
	}

}

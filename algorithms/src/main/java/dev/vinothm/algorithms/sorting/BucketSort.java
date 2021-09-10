package dev.vinothm.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    public void sort(int[] arr) {
	int numOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
	int max = max(arr);
	@SuppressWarnings("unchecked")
	List<Integer>[] buckets = new ArrayList[numOfBuckets];
	for (int i = 0; i < numOfBuckets; i++)
	    buckets[i] = new ArrayList<Integer>();
	for (int x : arr) {
	    int bucketIndex = (int) Math.ceil((float) x * (float) numOfBuckets / (float) max);
	    buckets[bucketIndex - 1].add(x);
	}
	for (int i = 0; i < numOfBuckets; i++)
	    printBucket(buckets[i]);
	int k = 0;
	for (int i = 0; i < numOfBuckets; i++) {
	    List<Integer> list = buckets[i];
	    list.sort((a, b) -> a.compareTo(b));
	    for (int j = 0; j < list.size(); j++) {
		arr[k++] = list.get(j);
	    }
	}
    }

    private void printBucket(List<Integer> bucket) {
	for (int x : bucket)
	    System.out.print(x);
	System.out.println();
    }

    private int max(int[] arr) {
	int max = arr[0];
	for (int x : arr)
	    if (max < x)
		max = x;
	return max;
    }

    public static void main(String[] args) {
	int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
	new BucketSort().sort(arr);
	for (int x : arr)
	    System.out.print(x);
	System.out.println();
    }
}

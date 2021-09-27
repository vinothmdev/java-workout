package dev.vinothm.algorithms.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestSum {

    public int[] bestSum(int target, int[] nums) {
	if (target == 0)
	    return new int[] {};
	if (target < 0)
	    return null;

	int[] shortArr = null;

	for (int n : nums) {
	    var rem = target - n;
	    var remSum = bestSum(rem, nums);

	    if (remSum == null)
		continue;

	    var sumArr = Arrays.copyOf(remSum, remSum.length + 1);
	    sumArr[sumArr.length - 1] = n;

	    if (shortArr == null || sumArr.length < shortArr.length) {
		shortArr = sumArr;
	    }
	}

	return shortArr;
    }

    public int[] bestSum(int target, int[] nums, Map<Integer, Object> map) {

	if (map.get(target) != null)
	    return (int[]) map.get(target);
	if (target == 0)
	    return new int[] {};
	if (target < 0)
	    return null;

	int[] shortArr = null;

	for (int n : nums) {
	    var rem = target - n;
	    var remSum = bestSum(rem, nums);

	    if (remSum == null)
		continue;

	    var sumArr = Arrays.copyOf(remSum, remSum.length + 1);
	    sumArr[sumArr.length - 1] = n;

	    if (shortArr == null || sumArr.length < shortArr.length) {
		shortArr = sumArr;
	    }
	}

	map.put(target, shortArr);
	return shortArr;
    }

    public static void main(String[] args) throws Exception {
	System.out.println(Arrays.toString(new BestSum().bestSum(7, new int[] { 5, 3, 4, 7, 20, 1, 2, 3, 4, 6, 7 })));
	System.out.println(Arrays.toString(new BestSum().bestSum(8, new int[] { 2, 3 })));
	System.out.println(Arrays.toString(new BestSum().bestSum(8, new int[] { 1, 4, 5 })));

	System.out
		.println(Arrays
			.toString(new BestSum()
				.bestSum(7, new int[] { 5, 3, 4, 7, 20, 1, 2, 3, 4, 6, 7 }, new HashMap<>())));
	System.out.println(Arrays.toString(new BestSum().bestSum(8, new int[] { 2, 3 }, new HashMap<>())));
	System.out.println(Arrays.toString(new BestSum().bestSum(8, new int[] { 1, 4, 5 }, new HashMap<>())));
    }

}
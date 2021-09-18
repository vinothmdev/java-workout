package dev.vinothm.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static boolean canSumRec(int target, int[] numbers) {
	if (target == 0)
	    return true;
	if (target < 0)
	    return false;

	for (int num : numbers) {
	    if (canSumRec(target - num, numbers))
		return true;
	}
	return false;
    }

    public static boolean canSumTop(int target, int[] numbers, Map<Integer, Boolean> memo) {
	if (memo.get(target) != null)
	    return memo.get(target);
	if (target == 0)
	    return true;
	if (target < 0)
	    return false;

	for (int num : numbers) {
	    if (canSumRec(target - num, numbers)) {
		memo.put(target, true);
		return true;
	    }
	}

	memo.put(target, false);
	return false;
    }

    public static void main(String[] args) {
	System.out.println(CanSum.canSumRec(7, new int[] { 2, 3 }));
	System.out.println(CanSum.canSumRec(7, new int[] { 2, 5 }));
	System.out.println(CanSum.canSumRec(7, new int[] { 2, 3, 5 }));
	System.out.println(CanSum.canSumRec(7, new int[] { 2, 4 }));
	System.out.println(CanSum.canSumTop(7, new int[] { 2, 3 }, new HashMap<Integer, Boolean>()));
	System.out.println(CanSum.canSumTop(7, new int[] { 2, 5 }, new HashMap<Integer, Boolean>()));
	System.out.println(CanSum.canSumTop(7, new int[] { 2, 3, 5 }, new HashMap<Integer, Boolean>()));
	System.out.println(CanSum.canSumTop(7, new int[] { 2, 4 }, new HashMap<Integer, Boolean>()));
    }

}

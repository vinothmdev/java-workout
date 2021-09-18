package dev.vinothm.algorithms.dp;

import java.util.ArrayList;
import java.util.List;

public class BestSum {

    private static final List<Integer> NULL_ARRAY = null;

    public static List<Integer> bestSum(int target, List<Integer> numbers) {
	// base cases
	if (target == 0)
	    return new ArrayList<Integer>();
	if (target < 0)
	    return NULL_ARRAY;

	var shortSum = NULL_ARRAY;

	for (Integer x : numbers) {
	    var rem = target - x;
	    var bestSum = bestSum(rem, numbers);
	    if (bestSum != NULL_ARRAY) {
		bestSum.add(x);
		if (shortSum == NULL_ARRAY || bestSum.size() < shortSum.size()) {
		    shortSum = bestSum;
		}
	    }
	}

	return shortSum;
    }

    public static void main(String[] args) {
	System.out.println(BestSum.bestSum(7, new ArrayList<>(List.of(5, 3, 4, 7))));
    }
}

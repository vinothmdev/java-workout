package dev.vinothm.algorithms.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equal {
    public static int equal(List<Integer> arr) {
	// Write your code here
	Collections.sort(arr);
	var curMax = arr.get(0);
	var totalOps = 0;
	var tracker = new HashMap<Integer, Integer>();
	for (int i = 1; i < arr.size(); i++) {
	    // 2 -> 3
	    if (arr.get(i) > curMax) {
		var diff = arr.get(i) - curMax;
		totalOps += totalOps(diff, tracker);
		curMax = curMax + diff;
	    }
	    // 1 1 2 4 6
	}
	return totalOps;
    }

    private static int totalOps(int value, Map<Integer, Integer> tracker) {
	if (tracker.get(value) == null) {
	    tracker.put(value, (value / 5) + (value % 5) / 2 + (value % 5) % 2);
	}
	return tracker.get(value);
    }

    public static void main(String[] args) {
	Equal.equal(new ArrayList<Integer>(List.of(1, 5, 5)));
    }
}

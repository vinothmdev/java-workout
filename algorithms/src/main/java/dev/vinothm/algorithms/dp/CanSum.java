package dev.vinothm.algorithms.dp;

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

    public static void main(String[] args) {
	System.out.println(CanSum.canSumRec(7, new int[] { 2, 3 }));
	System.out.println(CanSum.canSumRec(7, new int[] { 2, 5 }));
	System.out.println(CanSum.canSumRec(7, new int[] { 2, 3, 5 }));
	System.out.println(CanSum.canSumRec(7, new int[] { 2, 4 }));
    }

}

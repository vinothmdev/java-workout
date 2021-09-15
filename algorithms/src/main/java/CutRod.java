import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Dynamic Programming implementation of optimum rod cut problem
 * 
 * @author Vinoth Marimuthu
 *
 */
public class CutRod {

    /**
     * Return the optimum revenue for give length
     * 
     * @param priceList - price list as array
     * @param n         - length of original rod
     * 
     * @return effective revenue
     */
    public int cutRod(int[] priceList, int n) {
	int[] revenueList = new int[n + 1];
	Arrays.fill(revenueList, -1);
	revenueList[0] = 0;
	return cutRod(priceList, n, revenueList);
    }

    private int cutRod(int[] priceList, int n, int[] revenueList) {
	if (revenueList[n] >= 0)
	    return revenueList[n];
	revenueList[n] = IntStream.range(0, n).reduce(-1,
		(maxPrice, i) -> Math.max(maxPrice, priceList[i] + cutRod(priceList, n - i - 1, revenueList)));

	return revenueList[n];
    }

    public int cutRodIteration(int[] priceList, int n) {
	int[] revenueList = new int[n + 1];
	revenueList[0] = 0;
	for (int i = 1; i <= n; i++) {
	    for (int j = 1; j <= i; j++) {
		revenueList[i] = Math.max(revenueList[i], priceList[j - 1] + revenueList[i - j]);
	    }
	}
	return revenueList[n];
    }

    public int[] cutRodLengths(int[] priceList, int n) {
	int[] revenueList = new int[n + 1];
	int[] lengthList = new int[n + 1];
	revenueList[0] = 0;
	for (int i = 1; i <= n; i++) {
	    for (int j = 1; j <= i; j++) {
		if (revenueList[i] < priceList[j - 1] + revenueList[i - j]) {
		    revenueList[i] = priceList[j - 1] + revenueList[i - j];
		    lengthList[i] = j;
		}
	    }
	}
	printLengths(lengthList, n);
	return lengthList;
    }

    private void printLengths(int[] lengthList, int n) {
	while (n > 0) {
	    System.out.println(lengthList[n]);
	    n = n - lengthList[n];
	}
    }

    public static void main(String[] args) {
	var obj = new CutRod();
	int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
	int size = arr.length;
	System.out.println(obj.cutRod(arr, size));
	System.out.println(obj.cutRod(arr, size));
	System.out.println(obj.cutRodIteration(arr, size));
	obj.cutRodLengths(arr, 7);
    }
}

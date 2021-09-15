package dev.vinothm.algorithms.dp;

public class CoinChange {

    public int getPossibleOptions(int[] denominations, int amt) {
	int[] changeOptions = new int[amt + 1];
	changeOptions[0] = 1;
	for (int coin : denominations) {
	    for (int i = 1; i <= amt; i++) {
		if (coin <= i) {
		    changeOptions[i] += changeOptions[i - coin];
		}
	    }
	}
	return changeOptions[amt];
    }
}

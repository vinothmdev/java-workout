package dev.vinothm.algorithms.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CoinChangeTest {

    @Test
    void test() {
	assertEquals(4, new CoinChange().getPossibleOptions(new int[] { 1, 2, 3 }, 4));
	assertEquals(5, new CoinChange().getPossibleOptions(new int[] { 2, 5, 3, 6 }, 10));
    }

}

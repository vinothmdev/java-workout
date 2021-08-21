package dev.vinothm.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class DivisibleSumPairsTest {

	@Test
	void testDivisibleSumPairs() {
		var pairFinder = new DivisibleSumPairs();
		assertEquals(pairFinder.divisibleSumPairs(3, List.of(1, 3, 2, 6, 1, 2)),5);
	}

}

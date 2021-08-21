package dev.vinothm.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class BreakingTheRecordsTest {

	@Test
	void testBreakingRecords() {
		var scoreTracker = new BreakingTheRecords();
		assertEquals(scoreTracker.breakingRecords(List.of(10, 5, 20, 20, 4, 5, 2, 25, 1)), List.of(2,4));
	}

}

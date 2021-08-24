package dev.vinothm.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class MigratoryBirdsTest {

	@Test
	void testGetFrequentlySighted() {
		assertEquals(new MigratoryBirds().getFrequentlySighted(List.of(1, 1, 2, 2, 3)), 1);
		assertEquals(new MigratoryBirds().getFrequentlySighted(List.of(1, 4, 4, 4, 5, 3)), 4);
	}

}

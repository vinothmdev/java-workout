package dev.vinothm.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class SubarrayDivisionTest {

	@Test
	void testBirthday() {
		var divider = new SubarrayDivision();
		assertEquals(divider.birthday(List.of(1, 2, 1, 3, 2), 3, 2), 2);
	}

}

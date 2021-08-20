package dev.vinothm.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtopianTreeTest {

	@Test
	void test() {
		var tree = new UtopianTree();
		assertEquals(1, tree.estimateGrowth(0));
		assertEquals(2, tree.estimateGrowth(1));
		assertEquals(7, tree.estimateGrowth(4));
		assertEquals(14, tree.estimateGrowth(5));
		assertEquals(15, tree.estimateGrowth(6));
	}

}

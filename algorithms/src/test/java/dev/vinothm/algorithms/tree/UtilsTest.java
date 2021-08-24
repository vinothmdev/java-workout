package dev.vinothm.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UtilsTest {

	Node<Integer> testTree = null;
	Utils<Integer> treeUtils = new Utils<Integer>();

	@BeforeAll
	void init() {
		this.testTree = new Node<Integer>(1, null, null);
		testTree.left = new Node<Integer>(2, null, null);
		testTree.right = new Node<Integer>(3, null, null);
		testTree.left.left = new Node<Integer>(4, null, null);
		testTree.left.right = new Node<Integer>(5, null, null);
	}

	@Test
	void testTraversals() {
		assertEquals(treeUtils.preOrder(testTree, new ArrayList<Integer>()), List.of(1, 2, 4, 5, 3));
		assertEquals(treeUtils.inOrder(testTree, new ArrayList<Integer>()), List.of(4, 2, 5, 1, 3));
		assertEquals(treeUtils.postOrder(testTree, new ArrayList<Integer>()), List.of(4, 5, 2, 3, 1));
	}
}
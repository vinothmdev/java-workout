package dev.vinothm.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UtilsTest {

	Node testTree = null;
	Utils treeUtils = new Utils();

	@BeforeAll
	void init() {
		this.testTree = treeUtils.build(new int[] { 2, 4, 3, 6, 7, 13, 9, 15, 17, 18, 20 });
	}

	@Test
	void testInorderTraversals() {
		assertEquals(List.of(2, 3, 4, 6, 7, 9, 13, 15, 17, 18, 20),
				treeUtils.inOrder(testTree, new ArrayList<Integer>()));
		assertEquals(List.of(2, 3, 4, 6, 7, 9, 13, 15, 17, 18, 20),
				treeUtils.inOrderUsingStack(testTree, new ArrayList<Integer>()));
	}

	@Test
	void testPreorderTraversals() {
		assertEquals(List.of(15, 6, 3, 2, 4, 7, 13, 9, 18, 17, 20),
				treeUtils.preOrder(testTree, new ArrayList<Integer>()));
	}

	@Test
	void testPostorderTraversals() {
		assertEquals(List.of(2, 4, 3, 9, 13, 7, 6, 17, 20, 18, 15),
				treeUtils.postOrder(testTree, new ArrayList<Integer>()));
	}

	@Test
	void testMin() {
		Node testTree = treeUtils.build(new int[] { 2, 4, 3, 6, 7, 13, 9, 15, 17, 18, 20 });
		assertEquals(2, treeUtils.minimum(testTree).value);
	}

	@Test
	void successor() {
		Node testTree = treeUtils.build(new int[] { 2, 4, 3, 6, 7, 13, 9, 15, 17, 18, 20 });
		assertEquals(15, treeUtils.successor(testTree, 13).value);
		assertEquals(17, treeUtils.successor(testTree, 15).value);
		treeUtils.levelOrderTraversal(testTree);
		System.out.println("----------------------");
		treeUtils.delete(testTree, 13);
		treeUtils.levelOrderTraversal(testTree);
	}
}
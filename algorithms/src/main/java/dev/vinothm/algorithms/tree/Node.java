package dev.vinothm.algorithms.tree;

public class Node {
	int value;
	Node left;
	Node right;
	int level;

	Node(int value, Node left, Node right, int level) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.level = level;
	}
}
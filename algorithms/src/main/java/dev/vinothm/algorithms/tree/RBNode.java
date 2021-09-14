package dev.vinothm.algorithms.tree;

public class RBNode {

    int value;
    RBNode left;
    RBNode right;

    RBNode parent;
    NodeColor color;

    RBNode(int value, RBNode left, RBNode right, RBNode parent, NodeColor color) {
	this.value = value;
	this.left = left;
	this.right = right;

	this.parent = parent;
	this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
	return obj != null && ((RBNode) obj).value == this.value;
    }
}

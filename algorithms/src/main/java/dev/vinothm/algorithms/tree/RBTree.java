package dev.vinothm.algorithms.tree;

import java.util.LinkedList;
import java.util.List;

public class RBTree {

    RBNode root = null;

    public void leftRotate(RBNode x) {
	if (x.right == null)
	    return;
	// Mark x right as y
	var y = x.right;

	// Move y's left subtree as x right subtree
	x.right = y.left;
	if (y.left != null) {
	    y.left.parent = x;
	}

	// update y parent as x parent
	y.parent = x.parent;
	if (x.parent != null) {
	    if (x.equals(x.parent.left)) {
		x.parent.left = y;
	    } else {
		x.parent.right = y;
	    }
	} else {
	    root = y;
	}

	// move x as left subtree of x
	y.left = x;
	x.parent = y;
    }

    public void rightRotate(RBNode x) {
	if (x.left == null)
	    return;
	// mark x left a y
	var y = x.left;
	x.left = y.right;
	if (y.right != null) {
	    y.right.parent = x;
	}

	y.parent = x.parent;
	if (x.parent != null) {
	    if (x.equals(x.parent.left)) {
		x.parent.left = y;
	    } else {
		x.parent.right = y;
	    }
	} else {
	    root = y;
	}

	y.right = x;
	x.parent = y;
    }

    public void insert(int value) {
	var node = new RBNode(value, null, null, null, NodeColor.RED);

	RBNode p = null;
	RBNode x = root;
	while (x != null) {
	    p = x;
	    if (x.value > value) {
		x = x.left;
	    } else {
		x = x.right;
	    }
	}

	node.parent = p;
	if (p == null) {
	    this.root = node;
	} else if (p.value > value) {
	    p.left = node;
	} else {
	    p.right = node;
	}

	fixTree(node);
    }

    public void fixTree(RBNode node) {
	while (node.parent != null && node.parent.parent != null && node.parent.color == NodeColor.RED) {
	    if (node.parent == node.parent.parent.left) {
		var y = node.parent.parent.right;

		if (y != null && y.color == NodeColor.RED) {
		    node.parent.color = NodeColor.BLACK;
		    y.color = NodeColor.BLACK;
		    node.parent.parent.color = NodeColor.RED;
		    node = node.parent.parent;
		} else {
		    if (node.equals(node.parent.right)) {
			node = node.parent;
			leftRotate(node);
		    }
		    node.parent.color = NodeColor.BLACK;
		    node.parent.parent.color = NodeColor.RED;
		    rightRotate(node.parent.parent);
		}

	    } else {
		var y = node.parent.parent.left;

		if (y != null && y.color == NodeColor.RED) {
		    node.parent.color = NodeColor.BLACK;
		    y.color = NodeColor.BLACK;
		    node.parent.parent.color = NodeColor.RED;
		    node = node.parent.parent;
		} else {
		    if (node.equals(node.parent.right)) {
			node = node.parent;
			leftRotate(node);
		    }
		    node.parent.color = NodeColor.BLACK;
		    node.parent.parent.color = NodeColor.RED;
		    rightRotate(node.parent.parent);
		}
	    }
	}
	root.color = NodeColor.BLACK;
    }

    public void levelOrderTraversal(RBNode tree) {
	var queue = new LinkedList<RBNode>();
	queue.add(tree);
	while (queue.size() != 0) {
	    var node = queue.pop();
	    var color = node.color == NodeColor.RED ? "RED" : "BLACK";
	    System.out.println(String.format("<%3d, %5s>", node.value, color));
	    if (node.left != null)
		queue.add(node.left);
	    if (node.right != null)
		queue.add(node.right);
	}
    }

    public static void main(String[] args) {
	var tree = new RBTree();
	var inputs = List.of(1, 2, 4, 5, 7, 8, 11, 14, 15);
	inputs.forEach(e -> tree.insert(e));
	tree.levelOrderTraversal(tree.root);
    }
}

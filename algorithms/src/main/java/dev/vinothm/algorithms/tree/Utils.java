package dev.vinothm.algorithms.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Utils {
    public List<Integer> inOrder(Node tree, List<Integer> result) {
	if (tree != null) {
	    inOrder(tree.left, result);
	    result.add(tree.value);
	    inOrder(tree.right, result);
	}
	return result;
    }

    public List<Integer> preOrder(Node tree, List<Integer> result) {
	if (tree != null) {
	    result.add(tree.value);
	    preOrder(tree.left, result);
	    preOrder(tree.right, result);
	}
	return result;
    }

    public List<Integer> postOrder(Node tree, List<Integer> result) {
	if (tree != null) {
	    postOrder(tree.left, result);
	    postOrder(tree.right, result);
	    result.add(tree.value);
	}
	return result;
    }

    public List<Integer> inOrderUsingStack(Node tree, List<Integer> result) {
	var stack = new Stack<Node>();
	while (stack.size() > 0 || tree != null) {
	    while (tree != null) {
		stack.push(tree);
		tree = tree.left;
	    }
	    tree = stack.pop();
	    result.add(tree.value);
	    tree = tree.right;
	}
	return result;
    }

    public Node minimum(Node tree) {
	while (tree.left != null) {
	    tree = tree.left;
	}
	return tree;
    }

    public Node find(Node tree, int data) {
	if (tree == null || tree.value == data) {
	    return tree;
	} else if (tree.value > data) {
	    return find(tree.left, data);
	} else {
	    return find(tree.right, data);
	}
    }

    public Node successor(Node tree, int data) {
	Node node = find(tree, data);
	if (node != null && node.right != null) {
	    return minimum(node.right);
	}
	Node succ = null;
	while (tree != null && node != null && node.value != tree.value) {

	    if (node.value < tree.value) {
		succ = tree;
		tree = tree.left;
	    } else {
		tree = tree.right;
	    }

	}
	return succ;
    }

    public Node insert(Node tree, int data, int level) {
	if (tree == null)
	    return new Node(data, null, null, level);
	if (tree.value > data) {
	    tree.left = insert(tree.left, data, level + 1);
	    return tree;
	}
	tree.right = insert(tree.right, data, level + 1);
	return tree;
    }

    public Node build(int... data) {
	Node root = null;
	if (data.length > 0) {
	    root = new Node(data[0], null, null, 0);
	    for (int i = 1; i < data.length; i++) {
		insert(root, data[i], 0);
	    }
	}
	return root;
    }

    public void levelOrderTraversal(Node tree) {
	var queue = new LinkedList<Node>();
	queue.add(tree);
	while (queue.size() != 0) {
	    var node = queue.pop();
	    System.out.println(String.format("<%3d, %3d>", node.value, node.level));
	    if (node.left != null)
		queue.add(node.left);
	    if (node.right != null)
		queue.add(node.right);
	}
    }

    public void transplant(Node root, int u, int v) {
	if (root == null)
	    root = new Node(v, null, null, 0);
	Node p = null;
	Node vNode = find(root, v);
	while (root != null && root.value != u) {
	    p = root;
	    if (root.value > u)
		root = root.left;
	    else
		root = root.right;
	}

	if (p == null)
	    root = vNode;
	if (p.left != null && p.left.value == u)
	    p.left = vNode;
	else
	    p.right = vNode;

    }

    public void transplant(Node root, int u, Node v) {
	if (root == null)
	    root = v;
	Node p = null;

	while (root != null && root.value != u) {
	    p = root;
	    if (root.value > u)
		root = root.left;
	    else
		root = root.right;
	}

	if (p == null)
	    root = v;
	if (p.left != null && p.left.value == u)
	    p.left = v;
	else
	    p.right = v;

    }

    public void delete(Node root, int u) {
	Node tree = root;
	if (root == null)
	    return;

	Node p = null;

	while (root != null && root.value != u) {
	    p = root;
	    if (root.value > u) {
		root = root.left;
	    } else {
		root = root.right;
	    }
	}
	if (root == null) {
	    return;
	} else if (root.left == null) {
	    transplant(tree, u, root.right);
	} else if (root.right == null) {
	    transplant(tree, u, root.left);
	} else {
	    Node v = minimum(root.right);
	    if (v.value == root.right.value) {
		transplant(tree, v.value, v.right);
		v.right = root.right;
	    }
	    transplant(tree, u, v);
	    v.left = root.left;
	}
    }
}
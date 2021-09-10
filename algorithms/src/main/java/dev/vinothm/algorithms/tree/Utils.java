package dev.vinothm.algorithms.tree;

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

	public Node insert(Node tree, int data) {
		if (tree == null)
			return new Node(data, null, null);
		if (tree.value > data) {
			tree.left = insert(tree.left, data);
			return tree;
		}
		tree.right = insert(tree.right, data);
		return tree;
	}

	public Node build(int... data) {
		Node root = null;
		if (data.length > 0) {
			root = new Node(data[0], null, null);
			for (int i = 1; i < data.length; i++) {
				insert(root, data[i]);
			}
		}
		return root;
	}
}
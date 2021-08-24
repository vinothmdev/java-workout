package dev.vinothm.algorithms.tree;

import java.util.List;

public class Utils<T> {
  public List<T> inOrder(Node<T> tree, List<T> result) {
    if (tree != null) {
        inOrder(tree.left, result);
        result.add(tree.value);
        inOrder(tree.right, result);
    }
    return result;
  }

  public List<T> preOrder(Node<T> tree, List<T> result) {
    if (tree != null) {
        result.add(tree.value);
        preOrder(tree.left, result);
        preOrder(tree.right, result);
    }
    return result;
  }

  public List<T> postOrder(Node<T> tree, List<T> result) {
    if (tree != null) {
	    postOrder(tree.left, result);
	    postOrder(tree.right, result);
	    result.add(tree.value);
    }
    return result;
  }
}
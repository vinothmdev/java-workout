package dev.vinothm.algorithms.tree;

public class Utils<T> {
  public List<T> inOrder(Node<T> tree, List<T> result) {
    if (tree == null) return;
    
    inOrder(tree.left);
    result.add(tree.value);
    inOrder(tree.right);
  }

  public List<T> preOrder(Node<T> tree, List<T> result) {
    if (tree == null) return;

    result.add(tree.value);
    preOrder(tree.left);
    preOrder(tree.right);
  }

  public List<T> postOrder(Node<T> tree, List<T> result) {
    if (tree == null) return;

    postOrder(tree.left);
    postOrder(tree.right);
    result.add(tree.value);
  }
}
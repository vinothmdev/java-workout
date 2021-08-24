package dev.vinothm.algorithms.tree;

public class Node<T> {
  T value;
  Node<T> left;
  Node<T> right;

  Node(T value, Node<T> left, Node<T> right) {
    this.value = value;
    this.left  = left;
    this.right = right;
  }
}
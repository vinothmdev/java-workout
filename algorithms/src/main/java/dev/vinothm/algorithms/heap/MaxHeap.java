package dev.vintohm.algorithms.heap;

import java.util.stream.IntStream;
import java.util.List;

public class MaxHeap<T> {
  private T value;
  private MaxHeap<T> left;
  private MaxHeap<T> right;

  public MaxHeap(T value, MaxHeap<T> left, MaxHeap<T> right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public static int getParentOf(int index) {
    return index / 2 - 1;
  }

  public static int getLeftOf(int index) {
    return 2*index + 1;
  }

  public static int getRightOf(int index) {
    return 2*index+2;
  }

  public static boolean isMaxHeap(List input) {
    if (input == null) return false;

    return !/*NOT*/IntStream.range(1,input.size())
      .anyMatch(e -> input.get(MaxHeap.getParentOf(e)) < input.get(e));
  }
}
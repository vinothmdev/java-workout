package dev.vinothm.algorithms.heap;

import java.util.List;
import java.util.stream.IntStream;

public class MaxHeap {
  private int value;
  private MaxHeap left;
  private MaxHeap right;

  public MaxHeap(int value, MaxHeap left, MaxHeap right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public static int getParentOf(int index) {
    return index / 2;
  }

  public static int getLeftOf(int index) {
    return 2*index;
  }

  public static int getRightOf(int index) {
    return 2*index+1;
  }

  public static  boolean isMaxHeap(List<Integer> input) {
    if (input == null) return false;

    return !/*NOT*/IntStream.range(1,input.size())
      .anyMatch(e -> input.get(MaxHeap.getParentOf(e)) < input.get(e));
  }
}
package dev.vinothm.algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class UtilsTest {

  Node<Integer> testTree = null;
  Utils<Integer> treeUtils = new Utils<Integer>();

  @BeforeAll
  public void init() {
    this.testTree = new Node<Integer>(1,
                      new Node<Integer>(12,
                        new Node<Integer>(5,null, null),
                        new Node<Integer>(6,null, null)),
                      new Node<Integer>(9, null, null));
  }

  @Test
  public void testPreOrder() {
    assertEquals(treeUtils.preOrder(testTree, new ArrayList<Integer>()),
                  List.of(1, 12, 5, 9,6));
  }
}
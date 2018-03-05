package com.test.tree.balanced;

/**
 * AVL Tree test class.
 */
public class AvlTreeTest {

  public static void main(String[] args) {
    AvlTree avlTree = new AvlTree();
    avlTree.insert(10);
    avlTree.insert(20);
    avlTree.insert(30);
    avlTree.insert(40);
    avlTree.insert(50);
    avlTree.insert(60);
    avlTree.traverse();
  }
}

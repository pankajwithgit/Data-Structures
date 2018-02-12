package com.test.tree;

/**
 * Test BST.
 */
public class BSTreeTest {

  public static void main(String[] args) {
    BSTree<Integer> tree = new BSTree<>();
    tree.insert(25);
    tree.insert(20);
    tree.insert(27);
    tree.insert(15);
    tree.insert(22);
    tree.insert(26);
    tree.insert(30);
    tree.insert(17);
    tree.insert(29);
    tree.insert(32);

    // tree.traverseInOrder();
    // tree.traversePreOrder();
    tree.traversePostOrder();

    System.out.println();
    System.out.println(tree.search(22));
    System.out.println(tree.search(15));
    System.out.println(tree.search(34));

  }
}

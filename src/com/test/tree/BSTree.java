package com.test.tree;

/**
 * Binary search tree implementation.
 * 
 * <P>Has all traversal, search, insert operations available.
 * 
 */
public class BSTree<T extends Comparable<T>> {

  private TreeNode<T> root;

  public TreeNode<T> getRoot() {
    return root;
  }

  public void traverseInOrder() {
    if (root != null) {
      root.traverseInOrder();
    }
  }

  public void traversePreOrder() {
    if (root != null) {
      root.traversePreOrder();
    }
  }

  public void traversePostOrder() {
    if (root != null) {
      root.traversePostOrder();
    }
  }

  public void insert(T value) {
    if (root == null) {
      root = new TreeNode<>(value);
    } else {
      root.insert(value);
    }
  }

  public T search(T value) {
    if (root == null) {
      return null;
    }
    if (value.compareTo(root.getData()) == 0) {
      return root.getData();
    } else {
      return root.search(value);
    }
  }
}

package com.test.tree.balanced;

/**
 * Node class for AVL Tree.
 */
public class TreeNode<T extends Comparable<T>> {
  private T data;
  private TreeNode<T> leftChild;
  private TreeNode<T> rightChild;
  private int height;

  public TreeNode(T data) {
    this.data = data;
  }

  public void traverseInOrder() {
    if (leftChild != null) {
      leftChild.traverseInOrder();
    }
    System.out.println(data + ", ");
    if (rightChild != null) {
      rightChild.traverseInOrder();
    }
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public TreeNode<T> getLeftChild() {
    return leftChild;
  }

  public void setLeftChild(TreeNode<T> leftChild) {
    this.leftChild = leftChild;
  }

  public TreeNode<T> getRightChild() {
    return rightChild;
  }

  public void setRightChild(TreeNode<T> rightChild) {
    this.rightChild = rightChild;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return "" + data;
  }
}

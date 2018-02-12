package com.test.tree;

/**
 * Node class for BST.
 */
public class TreeNode<T extends Comparable<T>> {
  private T data;
  private TreeNode<T> leftChild;
  private TreeNode<T> rightChild;

  public TreeNode(T data) {
    this.data = data;
  }

  public void insert(T value) {
    if (value == data) {
      return;
    }

    // Check if value is less than node value
    if (value.compareTo(data) < 0) {
      if (leftChild == null) {
        leftChild = new TreeNode<>(value);
      } else {
        leftChild.insert(value);
      }
    } else {
      if (rightChild == null) {
        rightChild = new TreeNode<>(value);
      } else {
        rightChild.insert(value);
      }
    }
  }

  public T search(T value) {
    if (value.compareTo(data) == 0) {
      return data;
    }

    if (value.compareTo(data) < 0) {
      if (leftChild != null) {
        return leftChild.search(value);
      }
    } else {
      if (rightChild != null) {
        return rightChild.search(value);
      }
    }
    return null;
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

  public void traversePreOrder() {
    System.out.println(data + ", ");
    if (leftChild != null) {
      leftChild.traversePreOrder();
    }

    if (rightChild != null) {
      rightChild.traversePreOrder();
    }
  }

  public void traversePostOrder() {
    if (leftChild != null) {
      leftChild.traversePostOrder();
    }

    if (rightChild != null) {
      rightChild.traversePostOrder();
    }
    System.out.println(data + ", ");
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
}

package com.test.tree.balanced;

/**
 * AVL Tree implementation.
 * 
 * <ul>
 * <li>In-order traversal results into sorted list.</li>
 * <li>Time complexity worst case O(nlogn), Space complexity O(n)</li>
 * <li>After every insert, tree is considered for balancing (if needed)</li>
 * <ul>
 */
public class AvlTree {

  private TreeNode<Integer> root;

  public void traverse() {
    if (root == null)
      return;
    inOrderTraversal(root);
  }

  private void inOrderTraversal(TreeNode<Integer> node) {
    if (node.getLeftChild() != null) {
      inOrderTraversal(node.getLeftChild());
    }
    System.out.println(node.getData());
    if (node.getRightChild() != null) {
      inOrderTraversal(node.getRightChild());
    }
  }

  private int height(TreeNode<Integer> node) {
    if (node == null) {
      return -1;
    }
    return node.getHeight();
  }

  /**
   * If balance returned by this method is either > 1 or less than -1, tree is considered for
   * balancing.
   */
  private int getBalance(TreeNode<Integer> node) {
    if (node == null) {
      return 0;
    }
    return height(node.getLeftChild()) - height(node.getRightChild());
  }

  public void insert(Integer data) {
    root = insert(root, data);
  }

  private TreeNode<Integer> insert(TreeNode<Integer> node, Integer data) {
    if (node == null) {
      return new TreeNode<>(data);
    }
    if (data < node.getData()) {
      node.setLeftChild(insert(node.getLeftChild(), data));
    } else {
      node.setRightChild(insert(node.getRightChild(), data));
    }
    node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);

    node = settleVoilation(node, data);
    return node;
  }

  /**
   * Checks if rotation is required for node or not.
   */
  private TreeNode<Integer> settleVoilation(TreeNode<Integer> node, Integer data) {
    int balance = getBalance(node);

    // Left-Left case, Double left heavy
    if (balance > 1 && data < node.getLeftChild().getData()) {
      return rotateRight(node);
    }
    // Right-Right case, Double right heavy
    if (balance < -1 && data > node.getRightChild().getData()) {
      return rotateLeft(node);
    }
    // Left-Right case, double rotation will be performed
    if (balance > 1 && data > node.getLeftChild().getData()) {
      node.setLeftChild(rotateLeft(node.getLeftChild()));
      return rotateRight(node);
    }
    // Right-Left case, double rotation will be performed
    if (balance < -1 && data < node.getRightChild().getData()) {
      node.setRightChild(rotateRight(node.getRightChild()));
      return rotateLeft(node);
    }

    return node;
  }

  /**
   * Right rotation is performed.
   * <ul>
   * <li>Node's left child becomes root.</li>
   * <li>Node becomes right child of new root</li>
   * <li>Existing left child's right child becomes left child of node</li>
   */
  private TreeNode<Integer> rotateRight(TreeNode<Integer> node) {
    System.out.println("Rotating to right on node: " + node);
    TreeNode<Integer> tempLeftChild = node.getLeftChild();
    TreeNode<Integer> tempLeftRightChild = tempLeftChild.getRightChild();

    tempLeftChild.setRightChild(node);
    node.setLeftChild(tempLeftRightChild);

    node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
    tempLeftChild.setHeight(
        Math.max(height(tempLeftChild.getLeftChild()), height(tempLeftChild.getRightChild())) + 1);
    return tempLeftChild;
  }

  /**
   * Left rotation is performed.
   * <ul>
   * <li>Node's right child becomes root.</li>
   * <li>Node becomes left child of new root</li>
   * <li>Existing right child's left child becomes right child of node</li>
   */
  private TreeNode<Integer> rotateLeft(TreeNode<Integer> node) {
    System.out.println("Rotating to left on node: " + node);
    TreeNode<Integer> tempRightChild = node.getRightChild();
    TreeNode<Integer> tempRightLeftChild = tempRightChild.getLeftChild();

    tempRightChild.setLeftChild(node);
    node.setRightChild(tempRightLeftChild);

    node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild())) + 1);
    tempRightChild.setHeight(
        Math.max(height(tempRightChild.getLeftChild()), height(tempRightChild.getRightChild()))
            + 1);
    return tempRightChild;
  }
}

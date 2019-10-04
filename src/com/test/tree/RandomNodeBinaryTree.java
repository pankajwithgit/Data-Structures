class Node {
  Node left;
  Node right;
  int value;
  int children;

  public Node(int value) {
    this.value = value;
  }

  public void setLeftChild(Node left) {
    this.left = left;
  }

  public void setRightChild(Node right) {
    this.right = right;
  }

  public void setChildren(int children) {
    this.children = children;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}

import java.util.Random;

class Main {
  private Node root;
  
  public static void main(String[] args) {
    Main obj = new Main();
    obj.prepareTree();

    System.out.println(obj.getRandomNode());
  }

  public void prepareTree() {
    root = new Node(5);
    Node two = new Node(2);
    Node seven = new Node(7);
    Node one = new Node(1);
    Node three = new Node(3);
    Node six = new Node(6);
    Node eight = new Node(8);

    root.setLeftChild(two);
    root.setRightChild(seven);

    two.setLeftChild(one);
    two.setRightChild(three);

    seven.setLeftChild(six);
    seven.setRightChild(eight);

    updateChildren(root);
  }

  public int updateChildren(Node node) {
    if(node == null) return 0;
    int leftChildren = updateChildren(node.left);
    int rightChildren = updateChildren(node.right);
    node.children = leftChildren + rightChildren;
    return node.children + 1;
  }

  // Return each node with probability 1/N
  public Node getRandomNode() {
    if(root == null) throw new NullPointerException();
    Random rand = new Random();
    // Range of random number will be from 0(inclusive) to root.children(exclusive), hence we will add 1 to it.
    int nextInt = rand.nextInt(root.children + 1);
    return getRandomNode(root, nextInt);
  }

  // Recursive method. Binary search through tree to find the index. We use 
  // the number of children to determine which direction to go
  private Node getRandomNode(Node node, int count) {
    // check if count if pointing to node itself.
    if(count == getChildren(node.left)) return node;
    // check if count is lying in left sub tree.
    if(count < getChildren(node.left)) return getRandomNode(node.left, count);
    //else check in right sub tree and reset the count for right sub tree.
    return getRandomNode(node.right, count - getChildren(node.left) - 1);
  }

  // Return number of children of a node + 1 for itself
  private int getChildren(Node node) {
    if(node == null) return 0;
    return node.children + 1;
  }
}

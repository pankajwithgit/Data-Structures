class Main {
  public static void main(String[] args) {
    //Build tree first.
    Node one = new Node(0);
    Node two = new Node(1);
    Node three = new Node(2);
    Node four = new Node(2);
    Node five = new Node(2);
    Node six = new Node(1);
    Node seven = new Node(3);
    Node eight = new Node(3);
    Node nine = new Node(4);
    Node ten = new Node(5);

    one.left = two;
    one.right = three;

    two.left = four;
    two.right = five;

    three.left = six;
    three.right = seven;

    seven.left = nine;
    nine.left = ten;

    //four.left = eight;

    int max = visitNode(one);
    System.out.println(max);
  }

  public static class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }
  }

  // method for root node.
  public static int visitNode(Node node) {
    if(node == null) return 0;
    return Math.max(visitNode(node.left, node.value, 1), visitNode(node.right, node.value, 1));
  }

  // It is not neccessary that longest consecutive branch will always start from root. It can start from amy node. 
  public static int visitNode(Node node, int prevValue, int lenSoFar) {
    if(node == null) return lenSoFar;
    // check if current node is consecutive or not
    if(node.value == prevValue + 1) {
      int left = visitNode(node.left, node.value, lenSoFar + 1);
      int right = visitNode(node.right, node.value, lenSoFar + 1);
      return Math.max(left, right);
    } else {
      // start to find consecutive nodes from current node and return
      int left = visitNode(node.left, node.value, 1);
      int right = visitNode(node.right, node.value, 1);
      return Math.max(lenSoFar, Math.max(left, right));
    }
  }
}

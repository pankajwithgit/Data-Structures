// It will be a DFS solution. More details: https://leetcode.com/articles/count-univalue-subtrees/
// Got it from Dailycodingproblem.com. It's a Google question.
class Main {
  int count = 0;

  public static void main(String[] args) {
    Node root = new Node(5);
    root.left = new Node(1);
    root.right = new Node(5);
    root.left.left = new Node(5);
    root.left.right = new Node(5);
    root.right.right = new Node(5);

    Main obj = new Main();
    obj.isUnival(root);
    System.out.println(obj.count);
  }

  private boolean isUnival(Node node) {

    // leaf nodes are unival.
    if(node.left == null && node.right == null) {
      count++;
      return true;
    }

    boolean isUnival = true;

    if(node.left != null) {
       isUnival = isUnival(node.left) && isUnival && node.left.val == node.val;
    }

    if(node.right != null) {
      isUnival = isUnival(node.right) && isUnival && node.right.val == node.val;
    }
    if(!isUnival) return false;
    count++;
    return true;
  }
  

  private static class Node {
    Node left;
    Node right;
    int val;

    public Node(int val) {
      this.val = val;
    }
  }
}

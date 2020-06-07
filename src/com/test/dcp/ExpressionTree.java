class Main {
  public static void main(String[] args) {
    TreeNode root = new TreeNode("*");
    root.left = new TreeNode("+");
    root.right = new TreeNode("+");
    root.left.left = new TreeNode("3");
    root.left.right = new TreeNode("2");

    root.right.left = new TreeNode("4");
    root.right.right = new TreeNode("5");

    System.out.println(evalExpressionTree(root));
  }

  public static int evalExpressionTree(TreeNode root) {

    switch(root.val) {
      case "+" : return evalExpressionTree(root.left) + evalExpressionTree(root.right);
      case "-" : return evalExpressionTree(root.left) - evalExpressionTree(root.right);
      case "*" : return evalExpressionTree(root.left) * evalExpressionTree(root.right);
      case "/" : return evalExpressionTree(root.left) / evalExpressionTree(root.right);
      default: return Integer.valueOf(root.val);
    }
  }
}

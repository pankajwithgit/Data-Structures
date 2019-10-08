/*
Given a tree, write a function to convert it into a circular doubly linked
list from left to right by only modifying the existing pointers.

Initial tree is:
        1
    2       3
  4   5   6   7    

Result would be:
<-4 <-> 2 <-> 5 <-> 1 <-> 6 <-> 3 <-> 7 ->
*/
class Main {
  public static void main(String[] args) {
    //Build tree first.
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    Node six = new Node(6);
    Node seven = new Node(7);

    one.left = two;
    one.right = three;

    two.left = four;
    two.right = five;

    three.left = six;
    three.right = seven;

    //Convert now
    treeToList(one);
  }

  public static class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
      this.value = value;
    }
  }

  private static Node treeToList(Node node) {
    if(node == null) return node;
    Node leftList = treeToList(node.left);
    Node rightList = treeToList(node.right);

    // make node a circular one by pointing to itself.
    node.left = node;
    node.right = node;

    node = concatenate(leftList, node); // first concatenate left piece with root
    node = concatenate(node, rightList); // then concatenate right piece to it.
    return node;
  }
  
  private static Node concatenate(Node a, Node b) {
    // Here a can be <-4 <-> 2 <-> 5 <-> 1 ->
    // and b can be 6 <-> 3 <-> 7 ->
  
    // Base cases
    if(a == null) return b;
    if(b == null) return a;

    Node aEnd = a.left; // Preserve end of a list
    Node bEnd = b.left; // Preserve end of b list

    // Now connect a's front to b's end (and vica-versa) to make is circular.
    a.left = bEnd;
    bEnd.right = a;
    
    // Now connect a's rear to b's front and vica-versa
    aEnd.right = b;
    b.left = aEnd;
    return a;
  }
}

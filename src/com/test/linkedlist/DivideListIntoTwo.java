/*
Given a linked list, write a function to split the list into two equal
halves.
divide(1 ‐> 2 ‐> 3 ‐> 4) = 1 ‐> 2, 3 ‐> 4
divide(1 ‐> 2 ‐> 3 ‐> 4 ‐> 5) = 1 ‐> 2 ‐> 3, 4 ‐> 5
*/
class Main {
  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node two1 = new Node(2);
    Node one1 = new Node(1);
    Node four = new Node(4);

    one.next = two;
    two.next = three;
    three.next = two1;
    two1.next = one1;
    one1.next = four;

    divideListIntoTwo(one);
  }

  public static class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }

    public String toString() {
      return value + " -> " + next;
    }
  }

  // Reach the middle of the list and then divide into two.
  public static void divideListIntoTwo(Node head) {
    Node slowPointer = head;
    Node fastPointer = head.next;

    while(fastPointer != null && fastPointer.next != null) {
      slowPointer = slowPointer.next;
      fastPointer = fastPointer.next.next;
    }
    Node secondHead = slowPointer.next;
    slowPointer.next = null;

    System.out.println(head);
    System.out.println(secondHead);
  }
}

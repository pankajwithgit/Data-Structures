import java.util.HashSet;
import java.util.Set;

// Remove duplicates from an unsorted linked list with no extra space.
class Main {
  public static void main(String[] args) {
    Node head = new Node(6);
    head.next = new Node(8);
    head.next.next = new Node(9);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(4);
    head.next.next.next.next.next.next = new Node(9);
    head.next.next.next.next.next.next.next = new Node(10);
    head.next.next.next.next.next.next.next.next = new Node(8);

    removeDups(head);

    System.out.println(head);
  }

  static class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      next = null;
    }

    @Override
    public String toString() {
      return data + " -> " + next;
    }

  }

  // use 2 loops
  private static void removeDups(Node head) {
    Node first = head;
    while(first != null && first.next != null) { //outer loop
      Node second = first;
      while(second.next != null) { //inner loop
        if(first.data == second.next.data) {
          second.next = second.next.next;
        } else {
          second = second.next;
        }
      }
      first = first.next;
    }
  }
}

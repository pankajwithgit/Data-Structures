import java.util.HashSet;
import java.util.Set;

// Remove duplicates from an unsorted linked list.
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

  private static void removeDups(Node head) {
    // Maintain a set for visited values.
    Set<Integer> values = new HashSet<>();
    values.add(head.data);
    Node prev = head;
    Node current = head.next;
    while(current != null) {
      // Check if we have already encountered the value.
      if(values.contains(current.data)) {
        prev.next = current.next;
      } else {
        values.add(current.data);
        prev = prev.next;
      }
      current = current.next;
    }
  }
}

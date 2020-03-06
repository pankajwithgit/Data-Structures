// Find the kth to last element of a singly linked list.
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

    System.out.println(findkthToLast(head, 5));
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

  private static int findkthToLast(Node head, int k) {
    Node fastPtr = head;
    Node slowPtr = head;

    // Move fast Pointer by k steps first.
    for(int i = 1; i < k && fastPtr != null; i++) {
      fastPtr = fastPtr.next;
    }
    if(fastPtr == null){
      throw new IllegalArgumentException("not enough nodes");
    }

    / Now move both pointers.
    while(fastPtr != null && fastPtr.next != null) {
      fastPtr = fastPtr.next;
      slowPtr = slowPtr.next;
    }
    return slowPtr.data;
  }
}

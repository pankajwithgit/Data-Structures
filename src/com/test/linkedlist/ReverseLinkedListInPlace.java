/*
Reverse a linked list in place.
Iterative implementation follows.
*/
class Main {
  public static void main(String[] args) {
    ListNode node1 = new ListNode(2);
    ListNode node2 = new ListNode(3);
    ListNode node3 = new ListNode(7);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);

    node1.next = node2;
    node2.next = node3;
    node3.next = node4;
    node4.next = node5;

    System.out.println("before reverse: " + node1);
    ListNode newHead = reverse(node1);
    System.out.println("after reverse: " + newHead);
  }

  public static class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return value + " " + next;
    }
  }

  public static ListNode reverse(ListNode head) {
    if(head == null) return null;
    ListNode prev = null;
    while(head != null) {
      ListNode next = head.next; // save next node in a variable
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }
}

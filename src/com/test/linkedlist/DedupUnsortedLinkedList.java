import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted linked list, write a function to remove all the duplicates.
dedup(1 ‐> 2 ‐> 3 ‐> 2 ‐> 1) = 1 ‐> 2 ‐> 3

*/
class Main {
  public static void main(String[] args) {
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode two1 = new ListNode(2);
    ListNode one1 = new ListNode(1);

    one.next = two;
    two.next = three;
    three.next = two1;
    two1.next = one1;

    dedup(one);

    System.out.println(one);
  }

  public static class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
      this.value = value;
    }

    public String toString() {
      return value + " -> " + next;
    }
  }

  public static void dedup(ListNode head) {
    Set<Integer> set = new HashSet<>();
    ListNode prev = null;
    while(head != null) {
      if(set.contains(head.value)) { // contains will take O(1) time from hashset.
        prev.next = head.next;
      } else {
        set.add(head.value);
        prev = head;
      }
      head = head.next;
    }
    prev.next = null;
  } 
}

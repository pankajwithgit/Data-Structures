import com.test.linkedlist.impl.*;
import java.util.Stack;

public class PrintReverseLinkedList {
   public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();
    list.push(23);
    list.push(34);
    list.push(54);
    list.push(21);
    list.push(52);
    list.push(73);
    list.push(17);
    list.push(16);

    printReverse(list);
  }

  private static void printReverse(LinkedList<Integer> list) {
    Node<Integer> pointer = list.getHead();
    Stack<Integer> stack = new Stack<>();
    while(pointer != null) {
      stack.push(pointer.getValue());
      pointer = pointer.getNext();
    }

    // Print from stack
    while(!stack.isEmpty()) {
      System.out.print(stack.pop() + " ");
    }
  } 
}

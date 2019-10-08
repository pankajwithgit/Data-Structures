import java.util.Stack;

/*
Here is how we do it:

a) We will pop elements one by one and place them in programatic stack which is built during recursion.
b) Once we pop the last element from stack, we then start to push elements to the bottom of the stack.
c) Stack would be empty to begin with, but as soon as we have one or more elements in stack, we will use second level of 
recursion to move all existing elements upwards and make a room for new element to be inserted.
*/
class Main {
  public static void main(String[] args) {
    Stack stack = new Stack<>();
    stack.push(23);
    stack.push(3);
    stack.push(56);
    stack.push(21);
    stack.push(76);
    stack.push(27);
    System.out.println("Before Reverse: " + stack);
    reverse(stack);
    System.out.println("After Reverse: " + stack);
  }

  private static void reverse(Stack<Integer> stack) {
    // Check base case
    if(stack.isEmpty()) return;
    Integer temp = stack.pop();
    reverse(stack);
    insertAtBottom(stack, temp);
  }

  private static void insertAtBottom(Stack<Integer> stack, Integer x) {
    if(stack.isEmpty()) {
      stack.push(x);
      return;
    }
    Integer temp = stack.pop();
    insertAtBottom(stack, x);
    stack.push(temp);
  }
}

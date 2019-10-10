import java.util.Stack;
/*
Question : Given a stack, sort the elements in the stack using one additional
stack.
sort([1, 3, 2, 4]) = [1, 2, 3, 4]
*/
class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack();
    stack.push(4);
    stack.push(2);
    stack.push(3);
    stack.push(1);

    Stack sortedStack = sortStack(stack);
    System.out.println(sortedStack);
  }

  public static Stack sortStack(Stack<Integer> stack) {
    if(stack == null || stack.isEmpty()) return stack;

    Stack<Integer> newStack = new Stack<>();
    newStack.push(stack.pop()); // Push very first element to additional stack.
    while(!stack.isEmpty()) {
      Integer temp = stack.pop();
      // Now check in new stack till we continue to find smaller elements than temp,
      // continue to move them out, so that we place temp at the right position.
      while(!newStack.isEmpty() && temp > newStack.peek()) {
        stack.push(newStack.pop());
      }
      newStack.push(temp); //place temp at right position in new stack.
    }
    return newStack;
  }
}

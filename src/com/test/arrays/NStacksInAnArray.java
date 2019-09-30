/*
Question : Implement N > 0 stacks using a single array to store all stack data
(you may use auxiliary arrays in your stack object, but all of the objects in all of
the stacks must be in the same array). No stack should be full unless the entire
array is full.

Solution:
We can manage when n = 1, we just need to use array as backend data structure for stack, that's it.
we can manage when n=2, we can start to fill stack 1 data from array beginning and stack 2 data from array end. Once both of
their pointers are adjacent, we can consider array as full. That's it.
Problem will become big only when we have n >=3

Brute Force: Break array into n equal parts, reserve each part per stack. But this solution won't be space efficient because
we may face a situation where we are not able to add an element to a stack whereas we have good amount of blank space for 
other stack.
*/
class Main { // test class
  public static void main(String[] args) {
    Stacks stacks = new Stacks(4, 10);
    stacks.push(0, 5);
    stacks.push(0, 7);
    stacks.push(1, 8);
    stacks.push(1, 3);
    stacks.push(1, 2);
    stacks.push(0, 6);
    stacks.printData();
    System.out.println(stacks.pop(1));
    stacks.push(1, 10);
    stacks.printData();
  }
}


import java.util.*;

class Stacks {
  // topOfStack array will keep top element indexes for all n stacks. Will be initialized/filled with -1.
  private int[] topOfStack;
  // Actual data array.
  private int[] stackData;
  // nextIndex array will keep 2 types of information. Will keep next Index info (1,2,3,4..) at each index and -1 towards at 
  end to begin with. Once we start to fill data in stackData, corresponding index in nextIndex will keep last index of that 
  stack 2nd item from top to support cases of pop.
  private int[] nextIndex;
  //nextAvailable will keep next available index in stackData.
  private int nextAvailable;

  public Stacks(int n, int capacity) {
    topOfStack = new int[n];
    Arrays.fill(topOfStack, -1);

    nextAvailable = 0;
    stackData = new int[capacity];
    nextIndex = new int[capacity];
    for(int i = 0; i < nextIndex.length - 1; i++) {
      nextIndex[i] = i+1;
    }
    nextIndex[nextIndex.length - 1] = -1;
  }

  public void push(int stackIndex, int value) {
    if(stackIndex < 0 || stackIndex >= topOfStack.length) {
      throw new IndexOutOfBoundsException("stack Index is not correct.");
    }
    if(nextAvailable < 0) {
      throw new IllegalStateException("array is full");
    }
    int currentIndex = nextAvailable;
    stackData[currentIndex] = value;
    nextAvailable = nextIndex[currentIndex];
    nextIndex[currentIndex] = topOfStack[stackIndex];
    topOfStack[stackIndex] = currentIndex;
  }

  public int pop(int stackIndex) {
    if(stackIndex < 0 || stackIndex >= topOfStack.length) {
      throw new IndexOutOfBoundsException("stack Index is not correct.");
    }
    if(topOfStack[stackIndex] == -1) {
      throw new IllegalStateException("Stack is empty");
    }

    int currentIndex = topOfStack[stackIndex];
    topOfStack[stackIndex] = nextIndex[currentIndex];
    nextIndex[currentIndex] = nextAvailable;
    nextAvailable = currentIndex;

    return stackData[currentIndex];
  }

  public void printData() {
    for(int element : stackData) {
      System.out.println(element + " ");
    }
  }
}

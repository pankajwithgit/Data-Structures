package com.test.tree;

/**
 * Max heap implementation using arrays.
 * 
 * <p>
 * Parent = (i-1)/2
 * <p>
 * left child = 2i + 1;
 * <p>
 * right child = 2i + 2;
 */
public class Heap {

  private int[] heap;
  private int size;

  public Heap(int capacity) {
    heap = new int[capacity];
  }

  public boolean isFull() {
    return size == heap.length;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int getParent(int index) {
    return (index - 1) / 2;
  }

  public int getChild(int index, boolean left) {
    return 2 * index + (left ? 1 : 2);
  }

  public void insert(int item) {
    if (isFull()) {
      throw new RuntimeException("Heap is full");
    }
    heap[size] = item;
    upHeapify(size);
    size++;
  }

  /**
   * Method to delete a node from max heap.
   * <P>
   * a) replace target node with right most node to maintain the complete tree property of max heap.
   * b) if replacement is less then parent, fix heap below c) else, fix heap below and replace with
   * max child node
   */
  public int delete(int index) {
    if (isEmpty()) {
      throw new RuntimeException("heap is empty");
    }
    int deletedValue = heap[index];
    heap[index] = heap[size - 1];

    if (index == 0 || heap[index] < heap[getParent(index)]) {
      downHeapify(index, size - 1);
    } else {
      upHeapify(index);
    }
    size--;
    return deletedValue;
  }

  /**
   * Heap Sort. 
   * <P>
   * Time complexity: O(nlogn)
   * Space complexity: O(1) 
   */
  public void sort() {
    int lastHeapIndex = size - 1;
    for (int i = 0; i < lastHeapIndex; i++) {
      int temp = heap[0];
      heap[0] = heap[lastHeapIndex - i];
      heap[lastHeapIndex - i] = temp;
      downHeapify(0, lastHeapIndex - i - 1);
    }
  }

  public void printHeap() {
    for (int i = 0; i < size; i++) {
      System.out.print(heap[i]);
      System.out.print(", ");
    }
    System.out.println();
  }

  /**
   * Method to fix the tree below for max heap property.
   */
  private void downHeapify(int index, int lastHeapIndex) {
    int childToSwapIndex = 0;
    while (index <= lastHeapIndex) {
      int leftChildIndex = getChild(index, true);
      int rightChildIndex = getChild(index, false);

      // Check and see if left child really exists.
      if (leftChildIndex <= lastHeapIndex) {
        // check and see if right child exists or not.
        if (rightChildIndex > lastHeapIndex) {
          childToSwapIndex = leftChildIndex;
        } else { // when right child also exists
          childToSwapIndex =
              (heap[leftChildIndex] > heap[rightChildIndex] ? leftChildIndex : rightChildIndex);
        }
      }
      // compare swapable child with element at Index
      if (heap[index] < heap[childToSwapIndex]) {
        // swap values
        int temp = heap[index];
        heap[index] = heap[childToSwapIndex];
        heap[childToSwapIndex] = temp;
      } else {
        break;
      }
    }
  }

  /**
   * Method to fix the tree above for max heap property.
   */
  private void upHeapify(int index) {
    int newValue = heap[index];
    while (index > 0 && heap[index] > heap[getParent(index)]) {
      heap[index] = heap[getParent(index)];
      index = getParent(index);
    }
    heap[index] = newValue;
  }
}

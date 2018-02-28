package com.test.queues;

/**
 * Circular Queue implementation using arrays.
 */
public class Queue {

  private int[] queue;
  private int front = -1;
  private int rear = -1;
  private int size;

  public Queue(int capacity) {
    queue = new int[capacity];
  }

  public boolean isFull() {
    return size == queue.length;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void enqueue(int item) {
    if (isFull()) {
      throw new RuntimeException("queue is full");
    }
    if (isEmpty()) {
      front = (front + 1) % queue.length;
    }
    rear = (rear + 1) % queue.length;
    queue[rear] = item;
    size++;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("queue is empty");
    }
    int item = queue[front];
    queue[front] = 0;
    front = (front + 1) % queue.length;
    size--;
    return item;
  }

  public int front() {
    return queue[front];
  }

  public int rear() {
    return queue[rear];
  }
}

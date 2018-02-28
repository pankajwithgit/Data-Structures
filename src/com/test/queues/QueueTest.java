package com.test.queues;

public class QueueTest {

  public static void main(String[] args) {
    Queue queue = new Queue(5);
    queue.enqueue(5);
    queue.enqueue(16);
    queue.enqueue(8);
    queue.enqueue(12);
    queue.enqueue(34);

    System.out.println("front: " + queue.front());
    System.out.println("rear: " + queue.rear());

    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();
    queue.dequeue();

    System.out.println("front: " + queue.front());
    System.out.println("rear: " + queue.rear());
  }
}

package com.test.linkedlist.impl;

/*
 * Tests linked list.
 */
public class LinkedListTest {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();

    list.push(25);
    list.push(35);
    list.push(21);
    list.push(2);
    list.push(89);
    list.push(45);
    list.push(32);
    list.push(62);

    System.out.println("Add after an element");
    list.insertAfter(29, 89);
    list.traverse();

    System.out.println("Add an element at the end");
    list.append(53);
    list.traverse();

    System.out.println("Delete top element");
    list.deleteFront();
    list.traverse();

    System.out.println("Delete after");
    list.deleteAfter(21);
    list.traverse();
  }
}

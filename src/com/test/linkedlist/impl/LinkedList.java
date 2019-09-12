package com.test.linkedlist.impl;

/*
 * Implementation of Linked list with various useful methods.
 */
public class LinkedList<T> {

  private Node<T> head;
  
  public Node<T> getHead() {
    return head;
  }

  // Inserts a new element on the top of the list.
  public void push(T element) {
    Node<T> node = new Node<>(element);

    // check if head is available or not.
    if (head == null) {
      head = node;
    } else {
      node.setNext(head);
      head = node;
    }
  }

  public void insertAfter(T element, T after) {
    Node<T> targetNode = navigateTo(after);

    // If desired element is found
    if (targetNode != null) {
      Node<T> node = new Node<>(element);
      node.setNext(targetNode.getNext());
      targetNode.setNext(node);
    } else {
      System.out.println("Not able to find given element");
    }
  }

  public void append(T element) {
    Node<T> node = new Node<>(element);
    // If the linked list is empty, this node will be head
    if (head == null) {
      head = node;
      return;
    }
    // Navigate till last node and set new node as last
    Node<T> last = head;
    while (last.getNext() != null) {
      last = last.getNext();
    }
    last.setNext(node);
  }

  public void deleteFront() {
    if (head == null) {
      System.out.println("Linked list is already empty");
    } else {
      head = head.getNext();
    }
  }

  public void deleteAfter(T after) {
    Node<T> targetNode = navigateTo(after);

    // If desired element is found
    if (targetNode != null) {
      // Check if it has next element available
      if (targetNode.getNext() != null) {
        targetNode.setNext(targetNode.getNext().getNext());
      } else {
        System.out.println("Nothing to delete");
      }
    } else { // not found
      System.out.println("Not able to find given element");
    }
  }

  public void traverse() {
    // check to see if the linked list is already empty or not
    if (head == null) {
      System.out.println("Linked list is empty");
      return;
    }
    Node<T> last = head;
    while (last != null) {
      System.out.println(last.getValue() + ", ");
      last = last.getNext();
    }
  }

  private Node<T> navigateTo(T element) {
    // Navigate to target element
    Node<T> tmp = head;
    Node<T> targetNode = null;
    while (true) {
      if (tmp == null) {
        break;
      }
      if (tmp.compareTo(element) == 0) {
        targetNode = tmp;
        break;
      }
      tmp = tmp.getNext();
    }
    return targetNode;
  }
}

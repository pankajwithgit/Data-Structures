package com.test.linkedlist.impl;

public class Node<T> implements Comparable<T> {
  private T value;
  private Node<T> next;

  public Node(T value) {
    this.value = value;
    this.next = null;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> next) {
    this.next = next;
  }

  @Override
  public int compareTo(T arg) {
    if (arg == this.value) {
      return 0;
    }
    return 1;
  }
}

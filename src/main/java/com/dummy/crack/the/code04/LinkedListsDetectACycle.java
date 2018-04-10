package com.dummy.crack.the.code04;

public class LinkedListsDetectACycle {

  /*
   * Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
   * 
   * A Node is defined as: class Node { int data; Node next; }
   */
  class Node {
    int data;
    Node next;
  }

  boolean hasCycle(Node head) {
    if (head == null) {
      return false;
    }

    Node n1 = head;
    Node n2 = head.next;

    while (n1 != n2) {
      if (n2 == null || n2.next == null) {
        return false;
      }

      n1 = n1.next;
      n2 = n2.next.next;
    }

    return true;
  }
}

package com.dummy.crack.the.code06;

import java.util.Scanner;
import java.util.Stack;

/**
 * <p>
 * A queue is an abstract data type that maintains the order in which elements were added to it,
 * allowing the oldest elements to be removed from the front and new elements to be added to the
 * rear. This is called a First-In-First-Out (FIFO) data structure because the first element added
 * to the queue (i.e., the one that has been waiting the longest) is always the first one to be
 * removed.
 * </p>
 * <p>
 * A basic queue has the following operations:
 * </p>
 * <p>
 * <i>Enqueue:</i> add a new element to the end of the queue.<br/>
 * <i>Dequeue:</i> remove the element from the front of the queue and return it.
 * </p>
 * <p>
 * In this challenge, you must first implement a queue using <i>two stacks</i>. Then process
 * <b><i>q</i></b> queries, where each query is one of the following <b>3</b> types:
 * </p>
 * <p>
 * 1. 1 x: Enqueue element <b><i>x</i></b> into the end of the queue.<br/>
 * 2. 2: Dequeue the element at the front of the queue.<br/>
 * 3. 3: Print the element at the front of the queue.
 * </p>
 * <p>
 * <b>Input Format</b><br/>
 * The first line contains a single integer, <b><i>q</i></b>, denoting the number of queries. <br/>
 * Each line <b><i>i</i></b> of the <b><i>q</i></b> subsequent lines contains a single query in the
 * form described in the problem statement above. All three queries start with an integer denoting
 * the query <b><i>type</i></b>, but only query <b>1</b> is followed by an additional
 * space-separated value, <b><i>x</i></b>, denoting the value to be enqueued.
 * </p>
 * <p>
 * <b>Constraints</b><br/>
 * - 1 <= q <= 10^5 <br/>
 * - 1 <= type <= 3 <br/>
 * - 1 <= |x| <= 10^9 <br/>
 * - It is guaranteed that a valid answer always exists for each query of type <b>3</b>.
 * </p>
 * <p>
 * <b>Output Format</b><br/>
 * For each query of type <b>3</b>, print the value of the element at the front of the queue on a
 * new line.
 * </p>
 * <p>
 * <b>Sample Input</b><br/>
 * 10 <br/>
 * 1 42 <br/>
 * 2 <br/>
 * 1 14 <br/>
 * 3 <br/>
 * 1 28 <br/>
 * 3 <br/>
 * 1 60 <br/>
 * 1 78 <br/>
 * 2 <br/>
 * 2 <br/>
 * </p>
 * <p>
 * <b>Sample Output</b><br/>
 * 14 <br/>
 * 14 <br/>
 * </p>
 * <p>
 * <b>Explanation</b><br/>
 * We perform the following sequence of actions: <br/>
 * 1. Enqueue <b><i>42</i></b>; <b><i>queue </i> = { 42 }</b>. <br/>
 * 2. Dequeue the value at the top of the queue, <b>42</b>; <b><i>queue </i> = { }</b>. <br/>
 * 3. Enqueue <b><i>14</i></b>; <b><i>queue </i> = { 14 }</b>. <br/>
 * 4. Print the value at the top of the queue, <b>14</b>; <b><i>queue </i> = { 14 }</b>. <br/>
 * 5. Enqueue <b><i>28</i></b>; <b><i>queue </i> = { 14 <-- 28 }</b>. <br/>
 * 6. Print the value at the top of the queue, <b>14</b>; <b><i>queue </i> = { 14 <-- 28}</b>. <br/>
 * 7. Enqueue <b><i>60</i></b>; <b><i>queue </i> = { 14 <-- 28 <-- 60 }</b>. <br/>
 * 8. Enqueue <b><i>78</i></b>; <b><i>queue </i> = { 14 <-- 28 <-- 60 <-- 78 }</b>. <br/>
 * 9. Dequeue the value at the top of the queue, <b>14</b>; <b><i>queue </i> = { 28 <-- 60 <-- 78
 * }</b>. <br/>
 * 10. Dequeue the value at the top of the queue, <b>28</b>; <b><i>queue </i> = { 60 <-- 78 }</b>.
 * <br/>
 * 
 * @author tugrul.ocak
 */
public class QueuesATaleOfTwoStacksFromGLMD {

  public static class MyQueue<T> {
    Stack<T> stackNewestOnTop = new Stack<T>();
    Stack<T> stackOldestOnTop = new Stack<T>();

    public void enqueue(T value) { // Push onto newest stack
      stackNewestOnTop.push(value);
    }

    public T peek() {
      T p = stackNewestOnTop.get(0);
      return p;
    }

    public T dequeue() {
      T d = stackNewestOnTop.get(0);
      stackNewestOnTop.remove(0);
      return d;
    }
  }


  public static void main(String[] args) {
    MyQueue<Integer> queue = new MyQueue<Integer>();

    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    for (int i = 0; i < n; i++) {
      int operation = scan.nextInt();
      if (operation == 1) { // enqueue - means push
        queue.enqueue(scan.nextInt());
      } else if (operation == 2) { // dequeue - means get top of stack
        queue.dequeue();
      } else if (operation == 3) { // print/peek - means print the top element
        System.out.println(queue.peek());
      }
    }
    scan.close();
  }
}

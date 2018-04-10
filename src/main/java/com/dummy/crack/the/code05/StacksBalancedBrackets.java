package com.dummy.crack.the.code05;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StacksBalancedBrackets {

  public static boolean isBalanced(String expression) {
    if (expression.isEmpty() || (expression.length() % 2) == 1) {
      return false;
    }

    Stack<Character> stack = new Stack<Character>();
    Queue<Character> queue = new LinkedList<Character>();

    for (int i = 0; i < expression.length() / 2; i++) {
      stack.push(expression.charAt(i));
      queue.add(expression.charAt(expression.length() - 1 - i));
    }

    while (!stack.isEmpty()) {

      switch (stack.pop()) {
        case '{':
          if (!queue.peek().equals('}')) {
            return false;
          }
          break;
        case '(':
          if (!queue.peek().equals(')')) {
            return false;
          }
          break;
        case '[':
          if (!queue.peek().equals(']')) {
            return false;
          }
          break;
        default:
          break;
      }
    }

    return true;
  }

  /*
   * 
   * static int[] balancedOrNot(String[] expressions, int[] maxReplacements) { int[] a = new
   * int[expressions.length];
   * 
   * Stack<String> expStack = new Stack<String>(); for (int i=0; i < expressions.length; i++) { int
   * moves = getMoves(expressions[i]); if(moves==0) { a[i] = 1; continue; } if(moves >
   * maxReplacements[i]) { a[i] = 0; } else { a[i] = 1; } }
   * 
   * return a; }
   * 
   * static int getMoves(String str) { int moves=0; char[] symbols = str.toCharArray();
   * Stack<Character> s = new Stack<>(); LinkedList<Character> l = new LinkedList<Character>(); for
   * (char c : symbols) { s.push(c); l.add(c); }
   * 
   * for(int i=0; i < l.size(); i++) { if(s.pop() == l.get(i)) { moves++; } }
   * 
   * return moves; }
   */
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int a0 = 0; a0 < t; a0++) {
      String expression = in.next();
      System.out.println((isBalanced(expression)) ? "YES" : "NO");
    }
    in.close();
  }
}

package com.dummy.crack.the.code05;

import java.util.Scanner;
import java.util.Stack;

public class StacksBalancedBrackets {

  public static boolean isBalanced(String expression) {
    Stack<Character> s = new Stack<Character>();
    for (char c : expression.toCharArray()) {
      if (c == '{')
        s.push('}');
      else if (c == '[')
        s.push(']');
      else if (c == '(')
        s.push(')');
      else {
        if (s.empty() || c != s.peek()) return false;
        s.pop();
      }
    }
    return s.empty();
  }

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

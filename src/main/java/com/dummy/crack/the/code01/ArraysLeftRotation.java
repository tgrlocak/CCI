package com.dummy.crack.the.code01;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <p>
 * A left rotation operation on an array of size <i>n</i> shifts each of the array's elements
 * <b>1</b> unit to the left. For example, if <b>2</b> left rotations are performed on array [1, 2,
 * 3, 4, 5], then the array would become [3, 4, 5, 1, 2].
 * </p>
 * <p>
 * Given an array of <i>n</i> integers and a number, <i>d</i> , perform <i>d</i> left rotations on
 * the array. Then print the updated array as a single line of space-separated integers.
 * </p>
 * <p>
 * <b>Input Format</b>
 * </p>
 * <p>
 * The first line contains two space-separated integers denoting the respective values of <i>n</i>
 * (the number of integers) and <i>d</i> (the number of left rotations you must perform). The second
 * line contains <i>n</i> space-separated integers describing the respective elements of the array's
 * initial state.
 * </p>
 * <p>
 * <b>Constraints</b>
 * </p>
 * <p>
 * 1 <= n <= 10^5
 * </p>
 * <p>
 * 1 <= d <= n
 * </p>
 * <p>
 * 1 <= ai <= 10^6
 * </p>
 * <p>
 * <b>Output Format</b>
 * </p>
 * Print a single line of space-separated integers denoting the final state of the array after
 * performing left rotations.
 * <p>
 * <b>Sample Input</b>
 * </p>
 * <p>
 * 5 4
 * </p>
 * <p>
 * 1 2 3 4 5
 * </p>
 * <p>
 * <b>Sample Output</b>
 * </p>
 * 
 * <p>
 * 5 1 2 3 4
 * </p>
 * 
 * <p>
 * <b>Explanation</b>
 * </p>
 * <p>
 * When we perform <i>d=4</i> left rotations, the array undergoes the following sequence of changes:
 * </p>
 * <p>
 * [1, 2, 3, 4, 5] --> [2, 3, 4, 5, 1] --> [3, 4, 5, 1, 2] --> [4, 5, 1, 2, 3] --> [5, 1, 2, 3, 4]
 * </p>
 * <p>
 * Thus, we print the array's final state as a single line of space-separated values, which is <b>5
 * 1 2 3 4</b>.
 * </p>
 * 
 * @author tugrul.ocak
 */

public class ArraysLeftRotation {

  public static int[] arrayLeftRotation(int[] a, int n, int k) {
    int[] tmp = new int[n];
    System.arraycopy(a, k, tmp, 0, n-k);
    System.arraycopy(a, 0, tmp, n-k, k);
    return tmp;
  }
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int a[] = new int[n];
    for (int a_i = 0; a_i < n; a_i++) {
      a[a_i] = in.nextInt();
    }

    int[] output = new int[n];
    output = arrayLeftRotation(a, n, k);
    for (int i = 0; i < n; i++)
      System.out.print(output[i] + " ");

    System.out.println();
    in.close();
  }
}

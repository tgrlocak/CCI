package com.dummy.crack.the.code02;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <p>
 * Alice is taking a cryptography class and finding anagrams to be very useful. We consider two
 * strings to be anagrams of each other if the first string's letters can be rearranged to form the
 * second string. In other words, both strings must contain the same exact letters in the same exact
 * frequency For example, <b>bacdc</b> and <b>dcbac</b> are anagrams, but <b>bacdc</b> and
 * <b>dcbad</b> are not.
 * </p>
 *
 * <p>
 * Alice decides on an encryption scheme involving two large strings where encryption is dependent
 * on the minimum number of character deletions required to make the two strings anagrams. Can you
 * help her find this number?
 * </p>
 *
 * <p>
 * Given two strings, <b><i>a</i></b> and <b><i>b</i></b>, that may or may not be of the same
 * length, determine the minimum number of character deletions required to make <b><i>a</i></b> and
 * <b><i>b</i></b> anagrams. Any characters can be deleted from either of the strings.
 * </p>
 * <p>
 * <b>Input Format</b>
 * </p>
 * <p>
 * The first line contains a single string, <i><b>a</b></i>.
 * </p>
 * <p>
 * The second line contains a single string, <i><b>b</b></i>.
 * </p>
 * <p>
 * <b>Constraints</b>
 * </p>
 * <p>
 * 1 <= |<i><b>a</b></i>|, |<i><b>b</b></i>| <= 10^4
 * </p>
 * <p>
 * It is guaranteed that <i><b>a</b></i> and <i><b>b</b></i> consist of lowercase English alphabetic
 * letters (i.e., <i><b>a</b></i> through <i><b>z</b></i>). .
 * </p>
 * <p>
 * <b>Output Format</b>
 * </p>
 * <p>
 * Print a single integer denoting the number of characters you must delete to make the two strings
 * anagrams of each other.
 * </p>
 * <p>
 * <b>Sample Input</b>
 * </p>
 * <p>
 * cde
 * </p>
 * <p>
 * abc
 * </p>
 * <p>
 * <b>Sample Output</b>
 * </p>
 * <p>
 * 4
 * </p>
 * <p>
 * <b>Explanation</b>
 * </p>
 * <p>
 * We delete the following characters from our two strings to turn them into anagrams of each other:
 * </p>
 * <p>
 * 1. Remove <b><i>d</i></b> and <b><i>e</i></b> from <b><i>cde</i></b> to get <b><i>c</i></b>.
 * </p>
 * <p>
 * 2. Remove <b><i>a</i></b> and <b><i>b</i></b> from <b><i>abc</i></b> to get <b><i>c</i></b>.
 * </p>
 * <p>
 * We must delete <b>4</b> characters to make both strings anagrams, so we print <b>4</b> on a new
 * line.
 * </p>
 * 
 * @author tugrul.ocak
 */
public class StringsMakingAnagrams {

  public static int NUMBER_LETTERS = 26;

  public static int getDelta(int[] array1, int[] array2) {
    if (array1.length != array2.length) {
      return -1;
    }
    int delta = 0;
    for (int i = 0; i < array1.length; i++) {
      int difference = Math.abs(array1[i] - array2[i]);
      delta += difference;
    }
    return delta;
  }

  public static int[] getCharCounts(String s) {
    int[] charCounts = new int[NUMBER_LETTERS];
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int offset = (int) 'a';
      int code = c - offset;
      charCounts[code]++;
    }
    return charCounts;
  }

  public static int numberNeeded(String first, String second) {
    int[] charCount1 = getCharCounts(first);
    int[] charCount2 = getCharCounts(second);
    return getDelta(charCount1, charCount2);
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String a = in.next();
    String b = in.next();
    System.out.println(numberNeeded(a, b));
    in.close();
  }
}

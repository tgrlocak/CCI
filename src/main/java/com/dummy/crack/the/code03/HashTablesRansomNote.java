package com.dummy.crack.the.code03;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * <p>
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine
 * and wants to know if he can cut out whole words from it and use them to create an untraceable
 * replica of his ransom note. The words in his note are <i>case-sensitive</i> and he must use whole
 * words available in the magazine, meaning he cannot use substrings or concatenation to create the
 * words he needs.
 * </p>
 * <p>
 * Given the words in the magazine and the words in the ransom note, print <b>Yes</b> if he can
 * replicate his ransom note exactly using whole words from the magazine; otherwise, print
 * <b>No</b>.
 * </p>
 * <p>
 * <b>Input Format</b>
 * </p>
 * <p>
 * The first line contains two space-separated integers describing the respective values of
 * <b><i>m</i></b> (the number of words in the magazine) and <b><i>n</i></b> (the number of words in
 * the ransom note).
 * </p>
 * <p>
 * The second line contains <b><i>m</i></b> space-separated strings denoting the words present in
 * the magazine.
 * </p>
 * <p>
 * The third line contains <b><i>n</i></b> space-separated strings denoting the words present in the
 * ransom note.
 * </p>
 * <p>
 * <b>Constraints</b>
 * </p>
 * <p>
 * <i> 1 <= m, n <= 30000 </i>
 * </p>
 * <p>
 * <i> 1 <= length of any word <= 5 </i>
 * </p>
 * <p>
 * <i>Each word consists of English alphabetic letters (i.e., <b><i>a</i></b> to <b><i>z</i></b> and
 * <b><i>A</i></b> to <b><i>Z</i></b>).</i>
 * </p>
 * <p>
 * <i>The words in the note and magazine are case-sensitive.</i>
 * </p>
 * <p>
 * <b>Output Format</b>
 * </p>
 * <p>
 * Print <b>Yes</b> if he can use the magazine to create an untraceable replica of his ransom note;
 * otherwise, print <b>No</b>.
 * </p>
 * <p>
 * <b>Sample Input 0</b>
 * </p>
 * <p>
 * 6 4<br>
 * give me one grand today night<br>
 * give one grand today
 * </p>
 * <p>
 * <b>Sample Output 0</b>
 * </p>
 * <p>
 * Yes
 * </p>
 * <p>
 * <b>Sample Input 1</b>
 * </p>
 * <p>
 * 6 5<br>
 * two times three is not four<br>
 * two times two is four
 * </p>
 * <p>
 * <b>Sample Output 1</b>
 * </p>
 * <p>
 * No
 * </p>
 * <p>
 * <b>Explanation 1</b>
 * </p>
 * <p>
 * <i>two should occur 2 times in magazine</i>
 * </p>
 * 
 * <p>
 * <b>EXTRA TEST CASE</b>
 * </p>
 * <p>
 * <b>Sample Input 2</b>
 * </p>
 * <p>
 * 15 6<br>
 * apgo clm w lxkvg mwz elo bg elo lxkvg elo apgo apgo w elo bg<br>
 * elo lxkvg bg mwz clm w
 * </p>
 * <p>
 * <b>Sample Output 2</b>
 * </p>
 * <p>
 * YES
 * </p>
 * 
 * @author tugrul.ocak
 */
public class HashTablesRansomNote {

  public static String YES = "YES";
  public static String NO = "NO";

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    String magazine[] = new String[m];
    for (int magazine_i = 0; magazine_i < m; magazine_i++) {
      magazine[magazine_i] = in.next();
    }
    String ransom[] = new String[n];
    for (int ransom_i = 0; ransom_i < n; ransom_i++) {
      ransom[ransom_i] = in.next();
    }
    System.out.println(canCreate(magazine, ransom));
    in.close();
  }

  public static String canCreate(String[] arr1, String[] arr2) {
    Hashtable<String, Integer> result = new Hashtable<String, Integer>();

    for (String s : arr2) {
      if (!result.containsKey(s)) {
        result.put(s, Integer.valueOf(1));
      } else {
        result.put(s, result.get(s) + 1);
      }
    }

    for (String s : arr1) {
      if (result.containsKey(s) && result.get(s) != 0) {
        result.put(s, result.get(s) - 1);
      }
    }

    int res = result.values().stream().mapToInt(Integer::intValue).sum();
    return res == 0 ? YES : NO;
  }
}

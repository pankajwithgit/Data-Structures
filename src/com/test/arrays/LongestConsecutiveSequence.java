package com.test.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Algorithm to find longest consecutive sequence length.
 * 
 * <P>
 * In our case it would be: 16,17,18,19,20,21
 */
public class LongestConsecutiveSequence {

  public static void main(String[] args) {
    int[] arr = {1, 4, 6, 7, 9, 16, 34, 17, 21, 18, 2, 76, 19, 20};
    LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
    System.out.println("Longest consecutive seq length: " + obj.longestSeq(arr));
  }

  private int longestSeq(int[] arr) {
    Set<Integer> set = new HashSet<>();
    int longestSeq = 1;
    // put all elements in set to make it O(1) for frequent retrieval
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }

    for (Integer element : set) {
      // check if element is the starting element for a sequence or not.
      if (!set.contains(element - 1)) {
        Integer currElement = element;
        int count = 1;
        while (set.contains(currElement + 1)) {
          count++;
          currElement++;
        }
        longestSeq = Math.max(longestSeq, count);
      }
    }
    return longestSeq;
  }
}

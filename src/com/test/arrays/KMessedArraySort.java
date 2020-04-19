/*
Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.
Analyze the time and space complexities of your solution.
Example:
input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2
output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Constraints:
[time limit] 5000ms
[input] array.integer arr
1 ≤ arr.length ≤ 100
[input] integer k
0 ≤ k ≤ 20
[output] array.integer
*/

import java.io.*;
import java.util.*;

class Solution {

  static int[] sortKMessedArray(int[] arr, int k) {
    // base case
    if(arr == null || arr.length == 0 || k == 0) return arr;
    
    Queue<Integer> q = new PriorityQueue<>();
    int idx = 0;
    for(int i = 0; i < arr.length; i++) {
      q.add(arr[i]);
      if(q.size() == 2 * k + 1) {
        Integer element = q.poll();
        arr[idx] = element;
        idx++;
      }
    }
    // We will still have elements in the queue, scan those.
    while(!q.isEmpty()) {
      Integer element = q.poll();
      arr[idx] = element;
      idx++;
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
    
    System.out.println(Arrays.toString(sortKMessedArray(arr, 2)));
  }

}


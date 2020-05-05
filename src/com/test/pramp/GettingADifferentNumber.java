/*
Getting a Different Number
Given an array arr of unique nonnegative integers, implement a function getDifferentNumber that finds the smallest nonnegative integer that is NOT in the array.

Even if your programming language of choice doesn’t have that restriction (like Python), assume that the maximum value an integer can have is MAX_INT = 2^31-1. So, for instance, the operation MAX_INT + 1 would be undefined in our case.

Your algorithm should be efficient, both from a time and a space complexity perspectives.

Solve first for the case when you’re NOT allowed to modify the input arr. If successful and still have time, see if you can come up with an algorithm with an improved space complexity when modifying arr is allowed. Do so without trading off the time complexity.

Analyze the time and space complexities of your algorithm.

Example:

input:  arr = [0, 1, 2, 3]

output: 4 
Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ MAX_INT
0 ≤ arr[i] ≤ MAX_INT for every i, 0 ≤ i < MAX_INT
[output] integer
*/
import java.io.*;
import java.util.*;

class Solution {

  static int getDifferentNumber(int[] arr) {
    
    for(int i = 0; i < arr.length; i++) {
      int temp = Math.abs(arr[i]);
      if(temp < arr.length) {
        arr[temp] *= -1; 
      }
    }
    
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] > 0) {
        return i;
      }
    }
    return arr.length;
  }

  public static void main(String[] args) {
    int[] arr = {0, 2, 4, 1, 3, 5, 7};
    int[] test = {5, 1, 0, 3, 2, 6};
    System.out.println(getDifferentNumber(arr));
    System.out.println(getDifferentNumber(test));
  }
}

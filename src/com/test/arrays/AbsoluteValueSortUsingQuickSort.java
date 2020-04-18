/*
Absolute Value Sort
Given an array of integers arr, write a function absSort(arr), that sorts the array according to the absolute values of the numbers in arr. If two numbers have the same absolute value, sort them according to sign, where the negative numbers come before the positive numbers.

Examples:
input:  arr = [2, -7, -2, -2, 0]
output: [0, -2, -2, 2, -7]
Constraints:
[time limit] 5000ms
[input] array.integer arr
0 ≤ arr.length ≤ 10
[output] array.integer
*/

import java.io.*;
import java.util.*;

// Quick sort solution. It's pramp challenge.
class Solution {

	static int[] absSort(int[] arr) {
		doSort(arr, 0, arr.length - 1);
    return arr;
	}
  
  static void doSort(int[] arr, int start, int end) {
    if(start < end) {
      int pIndex = partition(arr, start, end);
      doSort(arr, start, pIndex - 1);
      doSort(arr, pIndex + 1, end);
    }
  }

  static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int absPivot = Math.abs(pivot);
    int pIndex = start;
    for(int i = start; i < end; i++) {
      int value = Math.abs(arr[i]);
      // check either abs value is less or if abs values are equal, go by natural ordering.
      if(value < absPivot || (value == absPivot && arr[i] < pivot)) { 
        int temp = arr[i];
        arr[i] = arr[pIndex];
        arr[pIndex] = temp;
        pIndex++;
      }
    }
    arr[end] = arr[pIndex];
    arr[pIndex] = pivot;
    return pIndex;
  }
  
	public static void main(String[] args) {
	  int[] arr = {2, -7, -2, -2, 0};
    absSort(arr);
    System.out.println(Arrays.toString(arr));
    
    int[] arr1 = {-2,3,5,-1,4};
    absSort(arr1);
    System.out.println(Arrays.toString(arr1));
	}
}

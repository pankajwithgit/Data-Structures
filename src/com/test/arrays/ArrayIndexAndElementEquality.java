import java.io.*;
import java.util.*;

/*
Brute force solution will cause O(n) time. Optimized solution would be to perform binary search, which will be O(log n).
Important information here is: elements are distinct and sorted already.
*/
class Solution {  
  static int indexEqualsValueSearch(int[] arr) {
    int len = arr.length;
    
    // base case
    if(len == 1) {
      return (arr[0] == 0) ? 0: -1;
    }
    return binarySearch(arr, 0, len - 1);
  }
  
  static int binarySearch(int[] arr, int start, int end) {
    if(start <= end) {
      int mid = start + (end - start) / 2;
      // If we find mid as target element, we need to check if it's previous element (i.e. mid - 1) has value greater than it's index or not.
      // If not, it's not worth traversing to left any more, mid is the lowest index possible which satisfies the condition.
      if(arr[mid] == mid && (mid == 0 || arr[mid - 1] < mid - 1)) {
        return mid;
      } else if(arr[mid] > mid) {
        return binarySearch(arr, start, mid - 1); // go left
      } else {
        return binarySearch(arr, mid + 1, end); // go right
      }
    }
    return -1;
  }

  public static void main(String[] args) {

  }
}

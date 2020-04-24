/*
Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, 
since we pick 5 and 5.
Same as house robber - https://github.com/pankajwithgit/leetcode/blob/master/dp/HouseRobber.java
Suggested by dailycodingproblem.com and asked by Airbnb and Uber.
*/
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[] arr = {1, 0, 3, 9, 2};
    int[] arr1 = {5,1,7,5};

    System.out.println(findLargestSumOfNonAdjNumbers(arr));
    System.out.println(findLargestSumOfNonAdjNumbers(arr1));
  }

  private static int findLargestSumOfNonAdjNumbers(int[] arr) {
    // base case
    if(arr == null || arr.length == 0) return 0;
    int len = arr.length;

    if(len == 1) return arr[0];
    
    int[] cache = new int[len];
    for(int i = len - 1; i >= 0; i--) {
      int firstPoint = 0;
      int secondPoint = 0;
      if(i + 2 < len) {
        firstPoint = cache[i + 2];
      }
      if(i + 3 < len) {
        secondPoint = cache[i + 3];
      }
      cache[i] = arr[i] + Math.max(firstPoint, secondPoint);
    }
    return Math.max(cache[0], cache[1]);
  }
}

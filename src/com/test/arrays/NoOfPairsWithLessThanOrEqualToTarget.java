// Find the number of pairs in the given array whose sum is lesser than or equal to given value. [Google]
// A = [2, 6, 10, 5, 12,  4, 1, 9, 8]    sum = 8
// Ans = [2,6] [2, 5], [2, 4] [2,1] [6,1] [5, 1]  [4, 1]  = 7
// Google question.

import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[] arr = {2,6,10,5,12,4,1,9,8};
    //int[] arr1 = {2,7,11,15}; // target=24
    System.out.println(numberOfPairs(arr, 8));
  }

  private static int numberOfPairs(int[] arr, int target) {
    int result = 0;
    Arrays.sort(arr);
    int start = 0;
    int end = arr.length - 1;
    while(start < end) {
      if(arr[start] + arr[end] > target) {
        end--;
      } else {
        result += end - start;
        start++;
      }
    }
    return result;
  }
}

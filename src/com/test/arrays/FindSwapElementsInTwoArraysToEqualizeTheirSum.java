//Find a pair of elements swapping which makes sum of two arrays same.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {
  public static void main(String[] args) {
    int[] arr1 = {4,1,2,1,1,2};
    int[] arr2 = {3,6,3,3};
    System.out.println(findSwapElements(arr1, arr2));

    int[] arr3 = {5,7,4,6};
    int[] arr4 = {1,2,3,8};
    System.out.println(findSwapElements(arr3, arr4));
  }

  private static List<Integer> findSwapElements(int[] arr1, int[] arr2) {
    List<Integer> result = new ArrayList<>();
    if(arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) return result;
    int sum1 = 0,sum2 = 0;

    for(int i = 0; i < arr1.length; i++) {
      sum1 += arr1[i];
    }

    for(int i = 0; i < arr2.length; i++) {
      sum2 += arr2[i];
    }

    if((sum1 - sum2) % 2 != 0) return result;

    int targetDiff = (sum1 - sum2) / 2;

    Arrays.sort(arr1);
    Arrays.sort(arr2);

    int p1 = 0,p2 = 0;

    while(p1 < arr1.length || p2 < arr2.length) {
      int diff = arr1[p1] - arr2[p2];
      if(diff == targetDiff) {
        result.add(arr1[p1]);
        result.add(arr2[p2]);
        break;
      } else if(diff < targetDiff) { // look for next element in arr1 to increase the difference next time.
        p1++;
      } else { // look for next element in arr2 to decrease the difference next time.
        p2++;
      }
    }
    return result;
  }
}

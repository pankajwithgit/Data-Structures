/*
Shortest Supersequence: You are given two arrays, one shorter (with all distinct elements) and one longer. Find the shortest subarray in the longer array that contains all the elements in the shorter array. The items can appear in any order.

EXAMPLE

Input:
{1, 5, 9}
{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7}
                      ^^^^^^^^^^
Output: [7, 10] (the underlined portion above)

Idea is to find the best closing index for each element in big array. Closing element is the element which
will mark the max index by which all of elements from small array will be covered down the array. 
Complexity: O(SB) time and O(B) space where S and B are the length arrays respectively. 
*/
import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[] b = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
    int[] s = {1,5,9};
    System.out.println(Arrays.toString(findShortestSuperSequence(b, s)));
  }

  private static int[] findShortestSuperSequence(int[] b, int[] s) {
    // Check for base cases first.
    if(b == null || s == null || b.length == 0 || s.length == 0) {
      throw new IllegalArgumentException();
    } 

    int[] closures = findClosures(b,s);

    //Find the best closure now.
    int bestStart = 0;
    int bestEnd = closures[0];
    int bestDiff = bestEnd - bestStart;
    for(int i = 0; i < closures.length; i++) {
      if(closures[i] == -1) continue;
      int diff = closures[i] - i;
      if(diff < bestDiff) {
        bestStart = i;
        bestEnd = closures[i];
        bestDiff = diff;
      }
    }
    return new int[] { bestStart, bestEnd };
  }

  // Find the max index which will cover all of the elements from small array. If no closure, use -1.
  private static int[] findClosures(int[] b, int[] s) {
    int[] closures = new int[b.length];
    for(int i = 0; i < s.length; i++) {
      int next = -1;
      for(int j = b.length - 1; j >= 0; j--) { // Sweep backwords 
        if(b[j] == s[i]) {
          next = j;
        }
        if((next == -1 || closures[j] < next) && closures[j] != -1) {
          closures[j] = next;
        }  
      }
    }
    return closures;
  }
}

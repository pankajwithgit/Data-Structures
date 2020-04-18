import java.io.*;
import java.util.*;

// Quick sort solution.
class Solution {

	static int[] absSort(int[] arr) {
    // We first neeed to convert int[] to Integer[].
    Integer[] boxedArray = Arrays.stream(arr) // IntStream
								.boxed()				// Stream<Integer>
								.toArray(Integer[]::new);
    
    Arrays.sort(boxedArray, (a,b) -> (Math.abs(a) != Math.abs(b)) ? Math.abs(a) - Math.abs(b) : a - b);
    
    int[] result = new int[arr.length];
      
    // convert back.
    for (int i = 0; i < boxedArray.length; i++) {
			result[i] = boxedArray[i].intValue();
		}
    return result;
	}
  
 
	public static void main(String[] args) {
	  int[] arr = {2, -7, -2, -2, 0};
    System.out.println(Arrays.toString(absSort(arr)));
    
    int[] arr1 = {-2,3,5,-1,4};
    System.out.println(Arrays.toString(absSort(arr1)));
	}
}

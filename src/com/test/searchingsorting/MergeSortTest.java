package com.test.searchingsorting;

/**
 * Merge Sort. Considered to be a good sorting algorithm if space is not an issue.
 * 
 * <p>
 * Couple of steps to be followed:
 * <ul>
 * <li>Repeatedly split array until we have one element array.</li>
 * <li>Start to merge unsorted arrays and sort them while merging.</li>
 * </ul>
 * 
 * <p>
 * Time Complexity: O(n log n) in worst case.
 * 
 * <p>
 * Space Complexity: O(n)
 */
public class MergeSortTest {

  public static void main(String[] args) {
    int[] array = {24, 34, 4, 56, 21, 87, 32, 91, 19};
    int[] tempArray = new int[array.length]; // temp array

    MergeSortTest test = new MergeSortTest();
    test.mergeSort(array, tempArray, 0, array.length - 1);

    // Print the sorted array
    for (int i = 0; i < array.length; i++) {
      System.out.println(array[i]);
    }
  }

  /**
   * This method will be called recursively.
   */
  private void mergeSort(int[] array, int[] tempArray, int leftStart, int rightEnd) {
    if (leftStart >= rightEnd) {
      return;
    }

    int mid = (leftStart + rightEnd) / 2;
    mergeSort(array, tempArray, leftStart, mid);
    mergeSort(array, tempArray, mid + 1, rightEnd);
    mergeHalves(array, tempArray, leftStart, rightEnd);
  }

  private void mergeHalves(int[] array, int[] tempArray, int leftStart, int rightEnd) {
    int mid = (leftStart + rightEnd) / 2;
    int leftEnd = mid;
    int rightStart = mid + 1;

    // Setup indexes
    int leftIndex = leftStart;
    int rightIndex = rightStart;
    int tempIndex = leftStart; // index for temp array

    while (leftIndex <= leftEnd && rightIndex <= rightEnd) {
      if (array[leftIndex] <= array[rightIndex]) {
        tempArray[tempIndex] = array[leftIndex];
        leftIndex++;
      } else {
        tempArray[tempIndex] = array[rightIndex];
        rightIndex++;
      }
      tempIndex++;
    }

    // At this point, at least one sub-array will have some elements left which are yet to be
    // merged.
    while (leftIndex <= leftEnd) {
      tempArray[tempIndex] = array[leftIndex];
      leftIndex++;
      tempIndex++;
    }

    while (rightIndex <= rightEnd) {
      tempArray[tempIndex] = array[rightIndex];
      rightIndex++;
      tempIndex++;
    }
    // copy elements from temp array to main array.
    System.arraycopy(tempArray, leftStart, array, leftStart, rightEnd - leftStart + 1);
  }
}

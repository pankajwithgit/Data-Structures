package com.test.searchingsorting;

/**
 * Quick Sort.
 * 
 * <p>
 * Couple of steps to be followed:
 * <ul>
 * <li>Pivot element is selected, we set last element as pivot.</li>
 * <li>Then we create partition by moving elements smaller than pivot to left of it and larger
 * elements to right of it.</li>
 * <li>Repeat same steps for resulting two sublists across partition.</li>
 * </ul>
 * 
 * <p>
 * Time Complexity: O(n log n) in average case and O(n^2) in worst case.
 * 
 * <p>
 * Space Complexity: O(1)
 */
public class QuickSort {

  public static void main(String[] args) {
    int[] arr = {24, 34, 4, 56, 21, 87, 32, 91, 19};
    QuickSort test = new QuickSort();
    test.quickSort(arr, 0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  private void quickSort(int[] array, int start, int end) {
    // check boundary condition which will help to break/stop recursive loops.
    if (start < end) {
      int pIndex = partition(array, start, end);
      quickSort(array, start, pIndex - 1);
      quickSort(array, pIndex + 1, end);
    }
  }

  /**
   * Select last element as pivot, do partition of list, elements smaller than pivot will move left
   * and larger elements to right.
   */
  private int partition(int[] array, int start, int end) {
    int pivot = array[end];
    int pIndex = start;
    for (int i = start; i < end; i++) {
      if (array[i] <= pivot) {
        int temp = array[i];
        array[i] = array[pIndex];
        array[pIndex] = temp;
        pIndex++;
      }
    }
    array[end] = array[pIndex];
    array[pIndex] = pivot;
    return pIndex;
  }
}

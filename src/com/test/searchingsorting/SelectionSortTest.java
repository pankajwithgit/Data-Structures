package com.test.searchingsorting;

/*
 * Selection Sort. 
 * <p> Sorts an array by repeatedly finding the minimum element from unsorted part
 * and placing it at the beginning.
 * 
 * Time complexity: O(N*N)
 * 
 * Space complexity: O(1)
 * 
 */
public class SelectionSortTest {

  public static void main(String[] args) {
    int[] arr = {24, 34, 4, 56, 21, 87, 32, 91, 19};
    SelectionSortTest test = new SelectionSortTest();
    test.selectionSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public void selectionSort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      int minIndex = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      // Swap values
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
  }
}

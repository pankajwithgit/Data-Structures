package com.test.searchingsorting;

/*
 * Insertion sort.
 * 
 * <p> Works the way we sort playing cards in our hands. it builds the final sorted array one item
 * at a time. It is much less efficient on large lists than other sort algorithms.
 * 
 * Time complexity: O(N*N)
 * 
 * Space complexity: O(1)
 * 
 */
public class InsertionSortTest {

  public static void main(String[] args) {
    int[] arr = {24, 34, 4, 56, 21, 87, 32, 91, 19};
    InsertionSortTest test = new InsertionSortTest();
    test.insertionSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public void insertionSort(int arr[]) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
      for (int j = i; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          // Swap values
          int temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}

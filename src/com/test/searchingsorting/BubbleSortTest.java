package com.test.searchingsorting;

/*
 * Bubble Sort.
 * 
 * <p> Works by repeatedly swapping the adjacent elements if they are in wrong order.
 * 
 * Time Complexity: O(n*n)
 * 
 * Space Complexity: O(1)
 */
public class BubbleSortTest {

  public static void main(String[] args) {
    int[] arr = {24, 34, 4, 56, 21, 87, 32, 91, 19};
    BubbleSortTest test = new BubbleSortTest();
    test.bubbleSort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public void bubbleSort(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j < n - i; j++) {
        if (arr[j - 1] > arr[j]) {
          // Swap values
          int temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }
}

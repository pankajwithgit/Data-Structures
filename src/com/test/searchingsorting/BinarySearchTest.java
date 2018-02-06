package com.test.searchingsorting;

public class BinarySearchTest {

  public static void main(String[] args) {
    int arr[] = {23, 34, 45, 56, 67, 78, 89, 96};
    int tobeSearched = 341;
    BinarySearchTest test = new BinarySearchTest();
    int index = test.search(arr, tobeSearched, 0, arr.length - 1);
    if (index == -1) {
      System.out.println("Not found");
    } else {
      System.out.println("found at: " + index);
    }
  }

  private int search(int arr[], int element, int left, int right) {
    if (left <= right) {
      int mid = left + (right - left) / 2;
      if (element == arr[mid]) {
        return mid;
      } else if (element > arr[mid]) {
        return search(arr, element, mid + 1, right);
      } else {
        return search(arr, element, left, mid - 1);
      }
    }
    return -1;
  }
}

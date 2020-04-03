// Find the element before which all the elements are smaller than it, and after which all are greater
// Input: arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9};
// Output: 4
// Explanation: All elements on left of arr[4] are smaller than it
// and all elements on the right are greater.
class Main {
  public static void main(String[] args) {
    int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
     System.out.println(findPivotElement(arr));
  }

  private static int findPivotElement(int[] arr) {
    if(arr == null || arr.length == 0) return -1; 
    int len = arr.length;
    
    int[] leftMax = new int[len];
    leftMax[0] = Integer.MIN_VALUE;

    for(int i = 1; i < len; i++) {
      leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
    }

    int rightMin = Integer.MAX_VALUE;
    for(int i = len - 1; i >= 0; i--) {
      if(arr[i] > leftMax[i] && arr[i] < rightMin) return i;
      rightMin = Math.min(rightMin, arr[i]);
    }
    return -1;
  }
}

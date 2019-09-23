/*
Given 2 sorted arrays, A and B, where A is long enough to hold the
contents of A and B, write a function to copy the contents of B into A without
using any buffer or additional memory.
A = {1,3,5,0,0,0}
B = {2,4,6}
mergeArrays(A, B)
A = {1,2,3,4,5,6}
*/
class Main {
  public static void main(String[] args) {
    int[] A = {1,3,5,0,0,0};
    int[] B = {2,4,6};
     
    mergeBArrayIntoAArray(A, B);

    // Print A array
    for(int i = 0; i < A.length; i++) {
      System.out.print(A[i] + " ");
    }
  }

  private static void mergeBArrayIntoAArray(int[] A, int[] B) {
    int aIndex1 = A.length - 1 - B.length;
    int aIndex2 = A.length - 1;
    int bIndex = B.length - 1;

    while(bIndex >= 0 && aIndex1 >= 0) {
      if(B[bIndex] > A[aIndex1]) {
        A[aIndex2] = B[bIndex];
        bIndex--;
      } else {
        A[aIndex2] = A[aIndex1];
        aIndex1--;
      }
      aIndex2--;
    }

    while(bIndex >= 0){
      A[aIndex2] = B[bIndex];
      bIndex--;
      aIndex2--;
    }
  }
}

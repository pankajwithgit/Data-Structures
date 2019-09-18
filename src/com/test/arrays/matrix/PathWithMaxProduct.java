/*
Que: Given a matrix, find the path from top left to bottom right with the greatest product by moving only down and right 
and return the max product. 
Brute Force solution: Find all possible paths and corresponding product values, compare them and shortlist one. We can also 
recursively scan throw each possible path and find the solution, but that won't be optimal solution for both time and space.

Here we create 2 caches (max and min) because we may have -ve values in matrix as well. So, we may want to keep both max and 
min values in parallel so that if we encounter -ve value, product of a -ve value with min +ve value would be maximum.
*/
class Main {
  public static void main(String[] args) {
    int[][] matrix = {
                      {-1,  2,   3},
                      {4,   5,  -6},
                      {7,   8,   9}
                     };
    int product = pathWithMaxProduct(matrix);
    System.out.println(product);
  }

  private static int pathWithMaxProduct(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0) return 0;

    // Initiate 2 caches for both min and max product values for each cell.
    int[][] maxCache = new int[matrix.length][matrix[0].length];
    int[][] minCache = new int[matrix.length][matrix[0].length];

    // Now iterate over matrix
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        // If you're in the top left corner, just copy to cache
        if(i == 0 && j == 0) {
          maxCache[i][j] = matrix[i][j];
          minCache[i][j] = matrix[i][j];
          continue;
        }
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        
        // If we're not at the top, consider the value above
        if(i > 0) { 
          int tempMax = Math.max(matrix[i][j] * maxCache[i-1][j],
                                 matrix[i][j] * minCache[i-1][j]);
          if(tempMax > maxVal) maxVal = tempMax;

          int tempMin = Math.min(matrix[i][j] * maxCache[i-1][j],
                                 matrix[i][j] * minCache[i-1][j]);
          if(tempMin < minVal) minVal = tempMin;
        }
        
        // If we're not on the left, consider the value to the left
        if(j > 0) { 
          int tempMax = Math.max(matrix[i][j] * maxCache[i][j-1],
                                 matrix[i][j] * minCache[i][j-1]);
          if(tempMax > maxVal) maxVal = tempMax;

          int tempMin = Math.min(matrix[i][j] * maxCache[i][j-1],
                                 matrix[i][j] * minCache[i][j-1]);
          if(tempMin < minVal) minVal = tempMin;
        }
        maxCache[i][j] = maxVal;
        minCache[i][j] = minVal;
      }
    }
    // Return the max value at the bottom right
    return maxCache[matrix.length - 1][matrix[0].length - 1];
  }
}

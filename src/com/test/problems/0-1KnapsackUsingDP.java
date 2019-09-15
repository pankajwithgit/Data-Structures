/*
To improve on the complexity by using recursion (i.e. 2 power n), we need to use Dynamic programming. Problem will be treated 
as a 2-D array and will be considered as bottom-up approach. We solve small sub-problems and build onto that.

Complexity in this approach would be O(n * M) where n is number of items and M is max weight allowed.

More details: https://www.byte-by-byte.com/01knapsack/?utm_source=optin_carrot&utm_medium=pdf&utm_campaign=50questions
*/
class Main {
  public static void main(String[] args) {
    int[] w = {1,2,3};
    int[] v = {6,10,12};

    int result = knapsack(5, w, v);

    System.out.println(result);
  }

  private static int knapsack(int M, int[] w, int[] v) {
    int[][] cache = new int[v.length + 1][M + 1];

    for(int i = 1; i <= w.length; i++) {
      for(int j = 1; j <= M; j++) {
        // If including item[i-1] would exceed max weight j, don't include the item. Otherwise take the max value of including or excluding the item
        if(w[i-1] > j) {
          cache[i][j] = cache[i-1][j];
        } else {
          cache[i][j] = Math.max(
                        cache[i-1][j], 
                        cache[i-1][j-w[i-1]] + v[i-1]);
        }
      }
    }
    return cache[v.length][M];
  }
}

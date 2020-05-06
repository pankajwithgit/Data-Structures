/*
This problem was asked by Facebook.

A builder is looking to build a row of N houses that can be of 3 different colors. He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by 3 matrix where the nth row and kth column represents the cost to build the nth house with kth color, return the minimum cost which achieves this goal.

Solution: Problem can be best visualized as a DP solution by building a 2-D DP array.

Asked by DailyCodingProblem.com
*/
class Main {
  public static void main(String[] args) {
    int[][] costs = {{3,2,6},
                     {4,2,7},
                     {1,3,8},
                     {3,2,1}};

    System.out.println(paintHouse(costs));
  }

  private static int paintHouse(int[][] costs) {
    if(costs == null || costs.length == 0) {
      return 0;
    }
    int rows = costs.length;
    int cols = 3;
    int[][] dp = new int[rows][cols];

    for(int i = 0; i < rows; i++) {
        if(i == 0) {
          dp[i][0] = costs[i][0];
          dp[i][1] = costs[i][1];
          dp[i][2] = costs[i][2];
        } else {
          dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
          dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
          dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
    }
    return Math.min(dp[rows - 1][0], Math.min(dp[rows - 1][1], dp[rows - 1][2])); // Answer lies in last row.
  }
}

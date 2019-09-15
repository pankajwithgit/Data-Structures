/*
Given a list of items with values and weights, as well as a max weight,
find the maximum value you can generate from items where the sum of the
weights is less than and equal to the max.

This problem is called 0-1 becuase you either use an item or don't use it at all. No partial item can be used.

This is recursuve way of solving 0-1 Knapsack problem.

Complexity: o(2 power n)
*/
class Main {
  public static void main(String[] args) {
    int[] w = {1,2,3};
    int[] v = {6,10,12};

    int result = knapsack(5, w, v, 0);

    System.out.println(result);
  }

  private static int knapsack(int M, int[] w, int[] v, int index) {
    //Check if Index is out of bounds.
    if(index == w.length) return 0;

    // if current item has more weight than total desired.
    if(w[index] > M) {
      return knapsack(M, w, v, index + 1);
    }

    // We either end up using the item or ignore it. Find max value of either case and use it.
    return Math.max(knapsack(M - w[index], w, v, index + 1) + v[index], knapsack(M, w, v, index+1));
  }
}

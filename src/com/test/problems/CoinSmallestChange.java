import java.util.ArrayList;
import java.util.List;

/*
Question : Given an input amount of change x, write a function to determine the
minimum number of coins required to make that amount of change.
Eg. (using American coins)
change(1) = 1
change(3) = 3
change(7) = 3
change(32) = 4
*/
class Main {
  public static void main(String[] args) {
    List<Integer> coins = new ArrayList<>();
    coins.add(25);
    coins.add(10);
    coins.add(5);
    coins.add(1);
    System.out.println(change(25, coins));
  }

  public static int change(int amount, List<Integer> coins) {
    int totalCoins = 0;
    int remainder = amount;
    for(int coin : coins) {
      totalCoins += remainder / coin;
      remainder = remainder % coin; 
      if(remainder == 0) {
        break;
      }
    }
    return totalCoins;
  }
}

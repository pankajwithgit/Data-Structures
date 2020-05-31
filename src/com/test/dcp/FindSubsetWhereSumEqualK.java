import java.util.*;

class Main {
  public static void main(String[] args) {
    int[] arr = {12, 1, 61, 5, 9, 2};
    System.out.println(subsetSumEqualK(arr, 62));
  }

  public static List<Integer> subsetSumEqualK(int[] arr, int k) {
    return helper(arr, k, 0, 0, new ArrayList<Integer>());
  }

  public static List<Integer> helper(int[] arr, int k, int sum, int start, List<Integer> list) {
    if(sum == k) return list;
    if(start == arr.length || sum > k) return null;

    for(int i = start; i < arr.length; i++) {
      list.add(arr[i]);
      List<Integer> res = helper(arr, k, sum + arr[i], i + 1, list);
      if(res != null) return res;
      list.remove(list.size() - 1);
    }
    return null;
  }
}

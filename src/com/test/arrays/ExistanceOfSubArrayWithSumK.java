class Main {
  public static void main(String[] args) {
    int[] nums = {10,1,3,5,2,15,18};
    System.out.println(hasSubarrayWithSumK(nums, 22));
  }

  private static boolean hasSubarrayWithSumK(int[] nums, int k) {
    // Base cases
    if(nums == null) return false;
    if(nums.length == 1) return nums[0] == k;

    int p1 = 0;
    int runningSum = nums[p1];
    int len = nums.length;
    for(int i = 0; i < len; i++) {
      while(runningSum < k && p1 < len) {
        runningSum += nums[++p1];
        if(runningSum == k) return true;
      }
      if(runningSum > k) {
        runningSum -= nums[i];
        if(runningSum == k) return true;
      }
    }
    return false;
  }
}

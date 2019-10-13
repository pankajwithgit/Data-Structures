class Main {
  public static void main(String[] args) {
    System.out.println(longestSubstring("touchwood", "uchuh"));
  }

  public static String longestSubstring(String a, String b) {
    String out = "";
    // Base case.
    if(a == null || b == null) return out;

    int[][] cache = new int[a.length()][b.length()];

    for(int i = 0; i < a.length(); i++) {
      for(int j = 0; j < b.length(); j++) {
        // We would only care about cases when chars at both i and j index match.
        if(a.charAt(i) == b.charAt(j)) {
          // boundary case, only fill 1
          if(i == 0 || j == 0) {
            cache[i][j] = 1;
          } else {
            // non boundary cases, look at diagonal value + 1. for (2,1) position, look at (1,0) position and add 1 to it. 
            cache[i][j] = cache[i-1][j-1] + 1;
          }
          // Keep on updating the longest substring side by side.
          if(cache[i][j] > out.length()) {
            out = a.substring(i - cache[i][j] + 1, i + 1);
          }
        }
      }
    }
    return out;
  }
}

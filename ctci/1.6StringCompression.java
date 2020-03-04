class Main {
  public static void main(String[] args) {
    System.out.println(compress("abcd"));
    System.out.println(compress("aabcccccaaa"));
  }

  private static String compress(String str) {
    if(str == null) return null;
    StringBuilder result = new StringBuilder();
    int count = 0;
    for(int i = 0; i < str.length(); i++) {
      count++;
      // check if either it is last element OR next element is not same as current.
      if((i+1 >= str.length()) || str.charAt(i) != str.charAt(i+1)) {
        result.append(str.charAt(i)).append(count);
        count = 0; //reset the counter as well
      }
    }
    return (result.length() < str.length() ? result.toString() : str);
  }
}

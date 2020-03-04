class Main {
  public static void main(String[] args) {
    String str1 = "Pale";
    String str2 = "Pala";
    System.out.println(isOneEditAway(str1, str2));
  }

  public static boolean isOneEditAway(String str1, String str2) {
    // Check to see if they are 0 edit away.
    if(str1.equals(str2)) return true;

    int l1 = str1.length();
    int l2 = str2.length();

    // Check if length difference is more than 1.
    if(Math.abs(l1 - l2) > 1) return false;

    int editCount = 0;
    int i = 0;
    int j = 0;

    // Iterate over strings char by char.
    while(i < l1 && j < l2) {
      if(str1.charAt(i) != str2.charAt(j)) {
        // Check if it is already different by 1.
        if(editCount == 1) {
          return false;
        }
        // Increment the counter for larger string.
        if(l1 > l2) {
          i++;
        } else if (l1 < l2) {
          j++;
        } else {
          i++;
          j++;
        }
        editCount++;
      }
      else {
        i++;
        j++;
      }
    }

    // Check if last char is extra in any string.
    if(i < l1 || j < l2) {
      editCount++;
    }
    return editCount == 1;
  }
}

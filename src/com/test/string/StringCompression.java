/*
Given a string, write a function to compress it by shortening every sequence of the same character to that character followed by the number of
repetitions. If the compressed string is longer than the original, you should return the original string.
Eg.
compress(“a”) = "a"
compress(“aaa”) = "a3"
compress(“aaabbb”) = "a3b3"
compress(“aaabccc”) = "a3b1c3"
*/
class Main {
  public static void main(String[] args) {
    System.out.println(compress("abc"));
    System.out.println(compress("aaabbbbcc"));
    System.out.println(compress("aaabcccc"));
  }

  public static String compress(String input) {
    if(input == null) return null;
    if(input.length() == 1) return input;
    StringBuilder output = new StringBuilder();
    int pointer = 0;
    while(pointer < input.length()) {
      char c = input.charAt(pointer);
      output.append(c);
      int count = 1;
      // check what all following chars are same as c.
      while((pointer < input.length() - 1) && c == input.charAt(pointer + 1)) {
        count++;
        pointer++;
      }
      pointer++;
      output.append(count);
    }
    //Return original string if output string is bigger.
    return output.length() > input.length() ? input : output.toString();  
  }
}

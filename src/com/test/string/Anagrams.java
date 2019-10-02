/*
https://www.byte-by-byte.com/anagrams/?utm_source=optin_carrot&utm_medium=pdf&utm_campaign=50questions
Given two strings, write a function to determine whether they are
anagrams.
● Eg.
isAnagram("", "") = true
isAnagram("A", "A") = true
isAnagram("A", "B") = false
isAnagram("ab", "ba") = true
isAnagram("AB", "ab") = true

*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.isEmpty() && t.isEmpty()) return true;
        if(s.isEmpty() || t.isEmpty() || s.length() != t.length()) return false;
        
        int[] arr = new int[26];
        
        for(char c : s.toLowerCase().toCharArray()) {
            arr[c - 'a']++;
        }
        for(char c : t.toLowerCase().toCharArray()) {
            arr[c - 'a']--;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) return false;
        }
        return true;
    }
}

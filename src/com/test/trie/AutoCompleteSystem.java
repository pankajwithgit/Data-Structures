/*
This problem was asked by Twitter.
Implement an autocomplete system. That is, given a query string s and a set of all possible query strings, return all strings in the set that have s as a prefix.
For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
From: dailycodingproblem.com
*/
import java.util.ArrayList;
import java.util.List;

class Trie {
  TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode current = root;
    for(char c : word.toCharArray()) {
      int index = c - 'a';
      if(current.arr[index] != null) {
        current = current.arr[index];
      } else {
        TrieNode node = new TrieNode();
        current.arr[index] = node;
        current = node;
      }
    }
    current.endOfWord = true;
  }

  public List<String> getMatches(String prefix) {
    List<String> results = new ArrayList<>();

    TrieNode current = root;
    for(char c : prefix.toCharArray()) {
      int index = c - 'a';
      if(current.arr[index] != null) {
        current = current.arr[index];
      } else {
        return results;
      }
    }
    getAllWords(current, prefix, results);
    return results;
  }

  private void getAllWords(TrieNode node, String prefix, List<String> results) {
    if(node.endOfWord) {
      results.add(prefix.toString());
    }
    for(int index = 0; index < node.arr.length; index++) {
      if(node.arr[index] != null) {
        char c = (char)(index + 'a');
        getAllWords(node.arr[index], prefix + c, results);
      }
    }
  }

  class TrieNode {
    TrieNode[] arr;
    boolean endOfWord;

    public TrieNode() {
      arr = new TrieNode[26];
    }
  }
}

class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();

    trie.insert("dog");
    trie.insert("deer");
    trie.insert("deal");
    trie.insert("down");

    System.out.println(trie.getMatches("de"));
  }
}

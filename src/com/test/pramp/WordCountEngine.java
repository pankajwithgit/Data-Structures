import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Main {
  static class Entry {
    int count;
    int order;
    String word;
    
    public Entry(int count, int order, String word) {
      this.count = count;
      this.order = order;
      this.word = word;
    }
  }
  
  static String[] parse(String document) {
    return document.toLowerCase().replaceAll("'","").replaceAll("\\W", " ").split("\\s+");
  }
  
  static class EntryComparator implements Comparator<Entry> {
     public int compare(Entry dis, Entry dat) {
      if (dis.count == dat.count) {
        return dis.order - dat.order;  
      }
      return dat.count - dis.count;
    }
  }

  static String[][] wordCountEngine(String document) {
    Map<String, Entry> entries = new HashMap<>();
    String[] words =  parse(document);
    
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (!entries.containsKey(word)) {
        entries.put(word, new Entry(0, i, word));
      }
      
      Entry entry = entries.get(word);
      entry.count += 1;
    }
  
    List<Entry> entryList = new ArrayList<>(entries.values());
    Collections.sort(entryList, new EntryComparator());

    String[][] result = new String[entryList.size()][2];
    for (int i = 0; i < entryList.size(); i++) {
      Entry e = entryList.get(i);
      result[i][0] = e.word;
      result[i][1] = String.valueOf(e.count);
    }
    return result;
  }

  public static void main(String[] args) {
    String[][] res = wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!");
    System.out.println(Arrays.deepToString(res));
  }

}

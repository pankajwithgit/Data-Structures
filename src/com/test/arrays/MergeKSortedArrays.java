import java.util.Arrays;
import java.util.PriorityQueue;

/*
There are k sorted arrays having n length each (assuming). This problem can be solved in multiple ways. 

First approach: Move all the array elements in a single but array and then perform sorting with any O(nlogn) algorithm. 
Time complexity in this case would be O(nk*log(nk)). Why?. It will take o(nk) time to move elements to single big array and then O(nk*log(nk)) 
for sorting. This approach donesn't take advantage of arrays being sorted already.

Second approach: Take one element from each array, compare and then move smallest element to resultant array. Keep moving running 
index on each array to campare and to be eventually moved to resultant array. This approach takes O(nk*k). Why?. We will touch total nk 
elements and to pick each element for final result, we will have to do k comparisons. Hence it is O(nk*k). This approach is even worst 
than first approach.

Preferred Approach: Taking advantage of arrays being sorted to begin with, we will push index 0 elements from each array to a
Priority queue. So, in our case, 1,2,3 will move to queue first. Then 1 (which is smallest of all 3 and on the top of queue) will be moved to result 
array. Now we will pick next element from the array (to which 1 belongs) and move to queue. Now pick top element from queue and move 
to result array. Continue like this. It has O(nk*logk) time complexity. Why?. we will we moving nk elements and it takes log(k) 
time to add an element to priority queue because queue will have k elements at max. Hence O(nk*logk).

How come priority queue has O(log n) insertion time?
In Java programming, Java Priority Queue is implemented using Heap Data Structures and Heap has O(log(n)) time complexity to insert 
and delete element. 
More info: https://www.interviewsansar.com/2015/05/16/what-is-time-complexity-for-offer-poll-and-peek-methods-in-priority-queue/#targetText=In%20Java%20programming%2C%20Java%20Priority,the%20element%20from%20the%20queue.

*/
class Main {
  public static void main(String[] args) {
    int[][] arrays = {
                      {1,4,7},
                      {2,5,8},
                      {3,6,9}
                     };
    int[] result = mergeKArrays(arrays);
    for(int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");   
    } 
  }

  private static int[] mergeKArrays(int[][] arrays) {
    PriorityQueue<QueueNode> pq = new PriorityQueue<>();
    int totalSize = 0;
    // First: find the total size and move 0 index elements to queue
    for(int i = 0; i < arrays.length; i++) {
      totalSize += arrays[i].length;
      if(arrays[i].length > 0) {
        pq.add(new QueueNode(i, 0, arrays[i][0]));
      }
    }
    int[] result = new int[totalSize];
    int currentIndex = 0;
    while(!pq.isEmpty()) {
      QueueNode n = pq.poll();
      result[currentIndex] = n.value;
      int newIndex = n.index + 1;
      // See if array has newIndex within length.
      if(newIndex < arrays[n.arrayIndex].length) {
        pq.add(new QueueNode(n.arrayIndex, newIndex, arrays[n.arrayIndex][newIndex]));
      }
      currentIndex++;
    }
    return result;
  }

  // We want to keep track to additional information for each element, hence this class.
  public static class QueueNode implements Comparable<QueueNode> {
    int arrayIndex;
    int index;
    int value;
    public QueueNode(int arrayIndex, int index, int value) {
      this.arrayIndex = arrayIndex;
      this.index = index;
      this.value = value;
    }

    @Override
    public int compareTo(QueueNode obj) {
      if(this.value > obj.value) return 1;
      if(this.value < obj.value) return -1;
      return 0;
    }
  }
}

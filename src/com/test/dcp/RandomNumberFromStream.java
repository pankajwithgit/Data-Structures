/*
How does this work
We need to prove that every element is picked with 1/n probability where n is the number of items seen so far. For every new stream item x, we pick a random number from 0 to ‘count -1’, if the picked number is ‘count-1’, we replace the previous result with x.
To simplify proof, let us first consider the last element, the last element replaces the previously-stored result with 1/n probability. So the probability of getting the last element as the result is 1/n.
Let us now talk about the second last element. When the second last element processed the first time, the probability that it replaced the previous result is 1/(n-1). The probability that the previous result stays when the nth item is considered is (n-1)/n. So the probability that the second last element is picked in the last iteration is [1/(n-1)] * [(n-1)/n] which is 1/n.
This problem was asked by Facebook.
*/
import java.util.Random; 
  
public class GFG  
{ 
    static int res = 0;    // The resultant random number 
    static int count = 0;  //Count of numbers visited so far in stream 
      
    //A method to randomly select a item from stream[0], stream[1], .. stream[i-1] 
    static int selectRandom(int x) 
    { 
        count++; // increment count of numbers seen so far 
          
        // If this is the first element from stream, return it 
        if (count == 1) 
            res = x; 
        else
        { 
             // Generate a random number from 0 to count - 1 
            Random r = new Random(); 
            int i = r.nextInt(count); 
              
            // Replace the prev random number with new number with 1/count probability 
            if(i == count - 1) 
                res = x; 
        } 
        return res; 
    } 
      
    // Driver program to test above function. 
    public static void main(String[] args) 
    { 
        int stream[] = {1, 2, 3, 4}; 
        int n = stream.length; 
        for(int i = 0; i < n; i++) 
            System.out.println("Random number from first " + (i+1) + 
                               " numbers is " + selectRandom(stream[i])); 
    } 
} 

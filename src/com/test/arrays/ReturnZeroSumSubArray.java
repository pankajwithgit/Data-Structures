/*
Given an array, write a function to find any subarray that sums to zero,
if one exists. Eg: zeroSum({1, 2, ‐5, 1, 2, ‐1}) = [2, ‐5, 1, 2]

Brute force solution is to find each and every sub-array by running 2 nested loops, find if sum comes to zero. This is not an 
efficient solution as it will take O(n^2) time.

Preferred approach: We keep track of running sum, if we find the same sum (as i index) again suppose at j index, means that the 
elements between index i and j sums to 0. This has linear time complexity.
*/
public int[] zeroSum(int[] arr) {
    HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
 
    int sum = 0;
    for (int i = 0; i <= arr.length; i++) {
        Integer oldIndex = sums.get(sum);
        if (oldIndex == null && i == arr.length) { // if we don't find existing sum and it is the end of the array.
            return null;
        } else if (oldIndex == null) { //if we don't find existing sum, update hashmap with present sum.
            sums.put(sum, i);
            sum += arr[i];
        } else { // if we manage to find existing sum, return sub-array in between both indexes.
            return Arrays.copyOfRange(arr, oldIndex, i);
        }
    }
    return null; // if not found, return null.
}

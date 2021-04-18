/**

Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

- arr.length >= 3
- There exists some i with 0 < i < arr.length - 1 such that:
  arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
  arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 
Example 1:

Input: arr = [2,1]
Output: false

Example 2:

Input: arr = [3,5,5]
Output: false

Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
 */

class Solution {
    public boolean validMountainArray(int[] arr) {  
        int size = arr.length;
        if (size < 3) {
            return false;
        }
                    
        int index = 0;
        for (int i = 1; i < size; i++) {
            if (arr[i - 1] < arr[i] ) {
                index++;
            } else {
                break;
            }
        }
                 
        if (index == 0 || index == size - 1) {
            return false;
        }
        
        int decreasingIndex = index;
        for (int i = size - 1; i > decreasingIndex; i-- ) {
            if (arr[i] < arr[i - 1]) {
                index++;
            } else {
                break;
            }
        }
        
        if (index == size - 1) {
            return true;
        }
        
        return false;
    }
}
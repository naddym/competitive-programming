/**
Give an array of positive and negative integers. Find the minimium subset product.

Example 1:
Input: [ -1, -1, 3, 4, 2 ]
Output: -24
 
Example 2:
Input: [ -1, 0]
Output: -1

*/

public class Solution {

    // greedy approach
    public int minSubsetProduct(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        Arrays.sort(arr);
        
        int nSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                break;
            }
            nSize++;
        }
        
        if (nSize == 0) {
            return arr[0];
        }
        
        int pSize = nSize;
        if (nSize % 2 == 0) {
            nSize--;
        }
        
        int minProduct = 1;
        for (int i = 0; i < nSize; i++) {
            minProduct *= arr[i];
        }
        
        // don't count 0's as product would
        // result in 0
        for (int i = pSize; i < arr.length; i++) {
            if (arr[i] != 0) {
              minProduct *= arr[i];   
            }
        }
        
        return minProduct;
    }
}
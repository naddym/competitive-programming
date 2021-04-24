/**
Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

Example 1:
  
  1        1          2             3      3
   \        \       /   \          /      /
    3        2     1     3        2      1
   /          \                  /        \ 
  2            3                1          2  
Input: n = 3
Output: 5

Example 2:

Input: n = 1
Output: 1
 
Constraints:

1 <= n <= 19

 */
class Solution {
    public int numTrees(int n) {
        return uniqueBST(1, n);
    }
    
    private int uniqueBST(int start, int end) {
        if (start >= end) {
            return 1;
        }
        
        int unique = 0;
        for (int i = start; i <= end ; i++) {
           // combinatorial = leftC1 * rightC1
           unique += uniqueBST(start, i - 1) * uniqueBST(i + 1, end); 
        }
        
        return unique;
    }
}
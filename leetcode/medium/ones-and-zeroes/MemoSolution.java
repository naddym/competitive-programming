/**
You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.

Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.

Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 
Constraints:

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] consists only of digits '0' and '1'.
1 <= m, n <= 100

*/

class MemoSolution {
    int[][][] memo;
    public int findMaxForm(String[] strs, int m, int n) {
        memo = new int[m + 1][n + 1][strs.length];
        return maxSubset(strs, m, n, 0);
    }
    
    private int maxSubset(String[] strs, int m, int n, int index) {
        if (index >= strs.length ||  m + n <= 0) {
            return 0;
        }
        
        if (memo[m][n][index] > 0) {
            return memo[m][n][index];
        }
        
        int[] counts = countOnesAndZeroes(strs[index]);
        
        int consider = 0;
        if ( m >= counts[0] && n >= counts[1]) {
            consider = 1 + maxSubset(strs, m - counts[0], n - counts[1], index + 1);
        }
        
        int dontConsider = maxSubset(strs, m, n, index + 1);
        
        memo[m][n][index] = Math.max(consider, dontConsider);
        return memo[m][n][index];
    }
    
    private int[] countOnesAndZeroes(String str) {
        int[] counts = new int[2];
        for (char c : str.toCharArray()) {
            counts[c - '0']++;
        }
        return counts;
    }
}
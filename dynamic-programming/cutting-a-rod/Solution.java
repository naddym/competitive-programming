/**

Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6) 

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1) 

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20

 */

public class Solution {

    public int rodCutting(int[] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }

        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];

        for(int j = 1; j < n; j++) {
            
            int left = 0;
            int right = j - 1;
            int max = cost[j];
            while (left <= right) {
                if (dp[left] + dp [right] > max){
                    max = dp[left] + dp[right];
                }
                left++;
                right--;
            }
            dp[j] = max;
        }

        return dp[n - 1];
    }
}
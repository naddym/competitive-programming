/**

    Paint House
    1. You are given a number n, representing the number of houses.
    2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house with red or blue or green color.
    3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive house with same color.

    Input
    1 5 7
    5 8 4
    3 2 9
    1 2 4

    Output
    8
*/

public class Solution {

    public int paintHouse(int[][] cost) {
        if (cost == null || cost.length == 0 ) {
            return 0;
        }

        int size = cost.length;
        int[][] dp = new dp[size][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][1];

        for (int i = 1; i < size; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        return Math.min(dp[size - 1][0], dp[size - 1][1], dp[size - 1][2]);
    }
}
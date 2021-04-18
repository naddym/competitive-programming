/**
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    Example 1:
    .---.---.---.
    | 1 | 3 | 1 |
    :---+---+---:
    | 1 | 5 | 1 |
    :---+---+---:
    | 4 | 2 | 1 |
    '---'---'---'

    Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
    Output: 7
    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
*/

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        
        int[][] dp = new int[rowSize][columnSize];
        dp[rowSize - 1][columnSize - 1] = grid[rowSize - 1][columnSize - 1];
        
        for (int j = columnSize - 2; j >= 0; j--) {
            dp[rowSize - 1][j] = grid[rowSize - 1][j] + dp[rowSize - 1][j + 1];
        }
        
        for (int i = rowSize - 2; i >= 0; i--) {
            dp[i][columnSize - 1] = grid[i][columnSize - 1] + dp[i + 1][columnSize - 1];
        }
        
        for (int i = rowSize - 2 ; i >= 0; i--) {
            for (int j = columnSize - 2; j >= 0 ; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        
        return dp[0][0];
    }
}
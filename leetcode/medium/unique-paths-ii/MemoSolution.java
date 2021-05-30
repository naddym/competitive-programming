/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and space is marked as 1 and 0 respectively in the grid.

Example 1:

Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:

Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 
Constraints:

m == obstacleGrid.length
n == obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] is 0 or 1.
*/

class MemoSolution {
    int[][] memo;
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return dfs(obstacleGrid, 0, 0);
    }
    
    private int dfs(int[][] obstacleGrid, int i, int j) {
        if (i < 0 || j < 0 || i >= obstacleGrid.length || j >= obstacleGrid[i].length || obstacleGrid[i][j] == 1) {
            return 0;
        } else if (memo[i][j] > -1) {
            return memo[i][j];
        } else if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            memo[i][j] = 1;
            return memo[i][j];
        } else {
            memo[i][j] = dfs(obstacleGrid, i, j + 1) + dfs(obstacleGrid, i + 1, j);
            return memo[i][j];
        }
    }
}
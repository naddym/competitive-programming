/**
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:

Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.

*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        
        int max = 0;
        for (int i = 0; i < m; i++ ) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    Queue<String> queue = new LinkedList<>();
                    queue.add(i + "#" + j);
                    max = Math.max(max, getArea(queue, m, n, grid));
                }
            }
        }
        
        return max;

    }
    
    private int getArea(Queue<String> queue, int m, int n, int[][] grid) {
        int count = 1;
        while (!queue.isEmpty()) {
            String position = queue.remove();
            int i =  Integer.valueOf(position.split("#")[0]);
            int j =  Integer.valueOf(position.split("#")[1]);
            
            if (i > 0 && grid[i - 1][j] == 1) {
                grid[i - 1][j] = 0;
                queue.add((i - 1) + "#" + j);
                count++;
            }
            
            if (j > 0 && grid[i][j - 1] == 1) {
                grid[i][j - 1] = 0;
                queue.add(i + "#" + (j - 1));
                count++;
            }
            
            if (i < m - 1 && grid[i + 1][j] == 1) {
                grid[i + 1][j] = 0;
                queue.add((i + 1) + "#" + j);
                count++;
            }
            
            if (j < n - 1 && grid[i][j + 1] == 1) {
                grid[i][j + 1] = 0;
                queue.add(i + "#" + (j + 1));
                count++;
            }
        }
        
        return count;
    }
}
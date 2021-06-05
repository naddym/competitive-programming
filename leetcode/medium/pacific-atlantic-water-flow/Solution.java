/**
You are given an m x n integer matrix heights representing the height of each unit cell in a continent. The Pacific ocean touches the continent's left and top edges, and the Atlantic ocean touches the continent's right and bottom edges.

Water can only flow in four directions: up, down, left, and right. Water flows from a cell to an adjacent one with an equal or lower height.

Return a list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.

Example 1:

Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

Example 2:

Input: heights = [[2,1],[1,2]]
Output: [[0,0],[0,1],[1,0],[1,1]]
 
Constraints:

m == heights.length
n == heights[i].length
1 <= m, n <= 200
0 <= heights[i][j] <= 105
*/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();
        
        int m = heights.length, n = heights[0].length;
        
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i , n - 1, atlantic, heights[i][n - 1]);
        }
        
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);
            dfs(heights, m - 1 , j, atlantic, heights[m - 1][j]);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> cordinates = Arrays.asList(i, j);
                if (pacific.contains(cordinates) && atlantic.contains(cordinates)) {
                    result.add(cordinates);
                }
            }
        }
                 
        return result;
    }
    
    private void dfs(int[][] heights, int row, int col, Set<List<Integer>> visited, int previousHeight) {
        if (row < 0 || col < 0 || row >= heights.length || col >= heights[row].length || heights[row][col] < previousHeight || visited.contains(Arrays.asList(row, col))) {
            return;
        }
        
        visited.add(Arrays.asList(row, col));
        
        dfs(heights, row + 1, col, visited, heights[row][col]);
        dfs(heights, row - 1, col, visited, heights[row][col]);
        dfs(heights, row, col + 1, visited, heights[row][col]);
        dfs(heights, row, col - 1, visited, heights[row][col]);
    }
}
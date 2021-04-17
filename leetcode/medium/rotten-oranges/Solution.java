/**

    You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.
    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

    Example 1:
    Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
    Output: 4

    Example 2:
    Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
    Output: -1
    Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

*/

class Solution {
    public int orangesRotting(int[][] grid) {
        
        List<String> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = 0;
                    list.add(i + "-" + j);
                }
            }
        }

        Queue<List<String>> queue = new LinkedList<>();
        queue.add(list);
        
        int minutes = -1;
        while (!queue.isEmpty()) {
            List<String> rottenOranges = queue.remove();
            
            List<String> affectedOranges = new ArrayList<>();
            for (int k = 0; k < rottenOranges.size(); k++) {
                
                String rottenOrange = rottenOranges.get(k);
                int i = Integer.parseInt(rottenOrange.split("-")[0]);
                int j = Integer.parseInt(rottenOrange.split("-")[1]);
                
                if (i > 0 && grid[i - 1][j] == 1){
                    grid[i - 1][j] = 0;
                    affectedOranges.add((i - 1) + "-" + j);
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 0;
                    affectedOranges.add(i + "-" + (j - 1));
                }
                if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 0;
                    affectedOranges.add ((i + 1) + "-" + j);
                }
                if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 0;
                    affectedOranges.add (i + "-" + (j + 1));
                }
            }

            if (!affectedOranges.isEmpty()) {
                queue.add(affectedOranges);   
            }
            
            minutes++;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return minutes;
    }
}
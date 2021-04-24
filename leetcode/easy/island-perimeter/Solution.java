/**
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example 1:

Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:

Input: grid = [[1]]
Output: 4

Example 3:

Input: grid = [[1,0]]
Output: 4
 
Constraints:

row == grid.length
col == grid[i].length
1 <= row, col <= 100
grid[i][j] is 0 or 1.

*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        Queue<String> queue = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(i + "#" + j);
                    break;
                }
            }
        }
        
        int perimeter = 0;
        while (!queue.isEmpty()) {
            String pos = queue.remove();
            int i = Integer.valueOf(pos.split("#")[0]);
            int j = Integer.valueOf(pos.split("#")[1]);
            
            if (grid[i][j] == -1) {
                continue;
            }
            
            if (i - 1 < 0) {
                perimeter++;
            }

            if ( i + 1 >= m) {
                perimeter++;
            }
            
            if (j - 1 < 0 ) {
                perimeter++;
            }
            
            if ( j + 1 >= n) {
                perimeter++;
            }
            
            if (i - 1 >= 0) {
                if ( grid[i - 1][j] == 0) {
                    perimeter++;
                } else if (grid[i - 1][j] == 1) {
                    queue.add((i - 1) + "#" + j);
                }
                
            }
 
            if (i + 1 < m) {
                if ( grid[i + 1][j] == 0) {
                    perimeter++;
                } else if (grid[i + 1][j] == 1) {
                    queue.add((i + 1) + "#" + j);
                }   
            }
      
            if (j - 1 >= 0) {
                if ( grid[i][j - 1] == 0) {
                    perimeter++;
                } else if (grid[i][j - 1] == 1) {
                    queue.add(i + "#" + (j - 1));
                } 
            }
 
            if (j + 1 < n) {
                if ( grid[i][j + 1] == 0) {
                    perimeter++;
                } else if (grid[i][j + 1] == 1) {
                    queue.add(i + "#" + (j + 1));
                }
            }
            
            grid[i][j] = -1;
        }

        return perimeter;
    }
}
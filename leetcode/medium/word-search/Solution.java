/**
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 
Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.


*/

class Solution {
    
    String word = null;
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[board.length][board[i].length];
                    if(findWord(board, i , j, 0, visited)) {
                        return true;   
                    }
                }
            }
        }
        
        return false;
    }

    private boolean findWord(char[][] board, int i, int j, int position, boolean[][] visited) {
        if (position == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j]) {
            return false;
        }

        if (board[i][j] == word.charAt(position)) {
            visited[i][j] = true;
            
            boolean left = findWord(board, i, j - 1, position + 1, visited);
            boolean right = findWord(board, i, j + 1, position + 1, visited);
            boolean up = findWord(board, i - 1, j, position + 1, visited);
            boolean down = findWord(board, i + 1, j, position + 1, visited);
            
            if (left || right || up || down) {
                return true;
            } 
            
            visited[i][j] = false;
        }
        
        return false;
    }
}
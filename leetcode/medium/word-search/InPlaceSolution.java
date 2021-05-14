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

class InPlaceSolution {
    
    String word = null;
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        
        this.word = word;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)){
                    if(findWord(board, i , j, 0)) {
                        return true;   
                    }
                }
            }
        }
        
        return false;
    }

    private boolean findWord(char[][] board, int i, int j, int position) {
        if (position == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(position)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';
        
        boolean left = findWord(board, i, j - 1, position + 1);
        boolean right = findWord(board, i, j + 1, position + 1);
        boolean up = findWord(board, i - 1, j, position + 1);
        boolean down = findWord(board, i + 1, j, position + 1);

        // restore original value
        board[i][j] = temp;
        
        return left || right || up || down;
    }
}
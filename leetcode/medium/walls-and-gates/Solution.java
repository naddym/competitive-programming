public class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, 0, i, j);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int count, int i, int j) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < count) {
            return;
        }

        rooms[i][j] = count;
        dfs(rooms, count + 1, i - 1, j);
        dfs(rooms, count + 1, i + 1, j);
        dfs(rooms, count + 1, i, j - 1);
        dfs(rooms, count + 1, i, j + 1);
    }
}
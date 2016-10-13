package Leetcode;

public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) {
            return;
        }
        int n = rooms[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, m ,n, 0);
                }
            }
        }
    }
    
    private void dfs(int[][] rooms, int i, int j, int m, int n, int depth) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (rooms[i][j] < depth) {
            return;
        } else {
            rooms[i][j] = depth;
            dfs(rooms, i + 1, j, m, n, depth + 1);
            dfs(rooms, i, j + 1, m, n, depth + 1);
            dfs(rooms, i - 1, j, m, n, depth + 1);
            dfs(rooms, i, j - 1, m, n, depth + 1);
        }
    }
}

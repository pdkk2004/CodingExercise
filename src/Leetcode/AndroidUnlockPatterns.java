package Leetcode;

public class AndroidUnlockPatterns {
    private int ways;
    
    public int numberOfPatterns(int m, int n) {
        boolean[][] visited = new boolean[3][3];
        for (int p = m; p <= n; p++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    visited[i][j] = true;
                    helper(i, j, p - 1, visited);
                    visited[i][j] = false;
                }
            }
        }
        return ways;
    }
    
    private void helper(int x, int y, int left, boolean[][] visited) {
        if (left == 0) {
            ways++;
            return;
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (visited[i][j] ||
                    (x == i && Math.abs(y - j) > 1) && !visited[x][1]
                    || (y == j && Math.abs(x - i) > 1) && !visited[1][y]
                    || (x + y == i + j && Math.abs(i - x) > 1) && !visited[1][1]
                    || (x - y == i - j && Math.abs(i - x) > 1) && !visited[1][1]
                    || (x == i && y == j)
                ) {
                    continue;
                } else {
                    visited[i][j] = true;
                    helper(i, j, left - 1, visited);
                    visited[i][j] = false;
                }
            }
        }
    }
}

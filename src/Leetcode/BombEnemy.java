package Leetcode;

public class BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        int rowKill = 0;
        int[] colKill = new int[n];
        int ret = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowKill = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        rowKill += grid[i][k] == 'E' ? 1 : 0;
                    }
                }
                
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colKill[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        colKill[j] += grid[k][j] == 'E' ? 1 : 0;
                    }
                }
                
                if (grid[i][j] == '0') { 
                    ret = Math.max(ret, rowKill + colKill[j]);
                }
            }
        }
        return ret;
    }
}

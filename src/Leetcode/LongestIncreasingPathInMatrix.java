package Leetcode;

public class LongestIncreasingPathInMatrix {
    private static int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    // 
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        if (r == 0) {
            return 0;
        }
        int c = matrix[0].length;
        
        int[][] mem = new int[r][c];
        
        int ret = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mem[i][j] == 0) {
                    mem[i][j] = dfs(matrix, i, j, r, c, mem);
                }
                ret = Math.max(mem[i][j], ret);
            }
        }
        return ret;
    }
    
    private int dfs(int[][] matrix, int i, int j, int r, int c, int[][] mem) {
        if (i < 0 || i >= r || j < 0 || j >= c) {
            return 0;
        }
        
        if (mem[i][j] > 0) {
            return mem[i][j];
        } else {
            mem[i][j] = 1;
        }
        
        for (int[] o : offset) {
            int x = i + o[0];
            int y = j + o[1];
            if (x >= 0 && x < r && y >= 0 && y < c && matrix[x][y] > matrix[i][j]) {
                int l = dfs(matrix, x, y, r, c, mem) + 1;
                mem[i][j] = Math.max(mem[i][j], l);
            }
        }
        return mem[i][j];
    }
}

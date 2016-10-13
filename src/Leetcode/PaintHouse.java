package Leetcode;

public class PaintHouse {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] C = new int[n + 1][3];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int preMin = findPreMin(C, i, j);
                C[i + 1][j] = preMin + costs[i][j];
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, C[n][i]);
        }
        return min;
    }
    
    private int findPreMin(int[][] C, int i, int color) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            if (j == color) {
                continue;
            }
            min = Math.min(min, C[i][j]);
        }
        return min;
    }
}

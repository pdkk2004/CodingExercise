package Leetcode;

import java.util.ArrayList;

public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        ArrayList<Integer> rIndex = new ArrayList<>();
        ArrayList<Integer> cIndex = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    rIndex.add(i);
                }
            }
        }
        
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] != 0) {
                    cIndex.add(j);
                }
            }
        }
        
        return minDist(rIndex) + minDist(cIndex);
    }
    
    private int minDist(ArrayList<Integer> positions) {
        int b = 0, e = positions.size() - 1;
        int dist = 0;
        while (b < e) {
            dist += positions.get(e) - positions.get(b);
            b++;
            e--;
        }
        return dist;
    }
}

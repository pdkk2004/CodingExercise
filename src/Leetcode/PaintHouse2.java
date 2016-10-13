package Leetcode;

public class PaintHouse2 {
    public int minCostII(int[][] costs) {
        int hn = costs.length;
        if (hn == 0) {
            return 0;
        }
        
        int preMin = 0;
        int preSecond = 0;
        int preColor = -1;
        
        for (int i = 0; i < costs.length; i++) {
            int curMin = Integer.MAX_VALUE;
            int curSecond = Integer.MAX_VALUE;
            int curColor = -1;
            
            for (int j = 0; j < costs[i].length; j++) {
                if (j != preColor) {
                    costs[i][j] += preMin;
                } else {
                    costs[i][j] += preSecond;
                }
                
                if (curMin > costs[i][j]) {
                    curSecond = curMin;
                    curMin = costs[i][j];
                    curColor = j;
                } else if (curSecond > costs[i][j]) {
                    curSecond = costs[i][j];
                }
            }
            preMin = curMin;
            preSecond = curSecond;
            preColor = curColor;
        }
        
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            ret = Math.min(ret, costs[costs.length - 1][i]);
        }
        return ret;
    }
}

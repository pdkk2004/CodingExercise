package Leetcode;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] sums = new int[m];
            for (int j = i; j < n; j++) {
                
                for (int r = 0; r < m; r++) {
                    sums[r] += matrix[r][j];
                }
                
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int val = 0;
                for (int r = 0; r < m; r++) {
                    val += sums[r];
                    Integer ceil = set.ceiling(val - k);
                    if (ceil != null) {
                        res = Math.max(res, val - ceil);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }
}

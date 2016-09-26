package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class LineReflection {
    public boolean isReflected(int[][] pts) {
        int n = pts.length;
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        
        Set<String> points = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int[] p = pts[i];
            minX = Math.min(p[0], minX);
            maxX = Math.max(p[0], maxX);
            points.add(p[0] + "|" + p[1]);
        }
        
        int sum = minX + maxX;
        for (int i = 0; i < n; i++) {
            int[] p = pts[i];
            String pRef = (sum - p[0]) + "|" + p[1];
            if (!points.contains(pRef)) {
                return false;
            }
        }
        return true;
    }
}

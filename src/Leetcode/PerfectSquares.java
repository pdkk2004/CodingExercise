package Leetcode;

import org.junit.Assert;
import org.junit.Test;

public class PerfectSquares {

    public static int numSquares(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] N = new int[n + 1];
        N[1] = 1;
        for (int i = 2; i <= n; i++) {
            int limit = (int)Math.sqrt(i);
            N[i] = findMin(N, i, limit);
        }
        return N[n];
    }
    
    private static int findMin(int[] N, int target, int limit) {
        int min = Integer.MAX_VALUE;
        for (int i = limit; i >= 1; i--) {
            int r = target - i * i;
            min = Math.min(min, N[r]);
        }
        return min + 1;
    }
    
    @Test
    public void test() {
    	Assert.assertEquals(3, numSquares(12));
    }
}

package Leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    //Remember to consider integer overflow.
    public int threeSumClosest(int[] num, int target) {
        long sum = Integer.MIN_VALUE;
        long diff = Integer.MAX_VALUE;
        Arrays.sort(num);
        for (int i = 0; i <= num.length - 3; i++) {
            int j = i + 1;
            int k = num.length - 1;
            while (j < k) {
                int tempSum = num[i] + num[j] + num[k];
                if (target - tempSum > 0) {
                    j++;
                } else if (target - tempSum < 0) {
                    k--;
                } else {
                    return tempSum;
                }
                long delt = Math.abs(tempSum - target);
                if (delt < diff) {
                    diff = delt;
                    sum = tempSum;
                }
            }
        }
        return (int)sum;
    }
}

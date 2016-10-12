package Leetcode;

public class CountOfRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        
        return countRangeSumHelper(sums, 0, n + 1, lower, upper);
    }
    
    private int countRangeSumHelper(long[] sums, int b, int e, int lower, int upper) {
        if (e - b <= 1) {
            return 0;
        }
        int mid = b + (e - b) / 2;
        int count = countRangeSumHelper(sums, b, mid, lower, upper) + countRangeSumHelper(sums, mid, e, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[e - b];
        for (int i = b, r = 0; i < mid; i++, r++) {
            while (j < e && sums[j] - sums[i] < lower) {
                j++;
            }
            while (k < e && sums[k] - sums[i] <= upper) {
                k++;
            }
            while (t < e && sums[t] < sums[i]) {
                cache[r++] = sums[t++];
            }
            cache[r] = sums[i];
            count += k - j;
        }
        System.arraycopy(cache, 0, sums, b, t - b);
        return count;
    }
}

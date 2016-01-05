package Leetcode;

import org.junit.Test;

import java.util.Arrays;

import org.junit.*;

/**
 * O(nlgn) Solution: http://www.hrwhisper.me/leetcode-longest-increasing-subsequence/
 * @author kkdpan
 *
 */
public class LongestIncreasingSubsequence {
	
	/**
	 * DP O(n^2) solution.
	 * @param nums
	 * @return
	 */
    public static int lengthOfLIS(int[] nums) {
        int l = nums.length;
        if (l == 0) {
            return 0;
        }
        int[] N = new int[l];
        N[0] = 1;
        
        for (int i = 1; i < l; i++) {
            N[i] = 1 + findPreLongest(nums, N, i);
        }
        
        return Arrays.stream(N).max().orElse(0);
    }
    
    private static int findPreLongest(int[] nums, int[] length, int index) {
        int max = 0;
        for (int i = 0; i < index; i++) {
            if (nums[i] < nums[index]) {
                max = Math.max(max, length[i]);
            }
        }
        return max;
    }
    
    @Test
    public void test() {
    	int[] input = {1,3,6,7,9,4,10,5,6};
    	Assert.assertEquals(6, lengthOfLIS(input));
    }
}

package Leetcode;

import java.util.Arrays;

public class ThreeSumSmaller {
	
    public int threeSumSmaller(int[] nums, int target) {
        int l = nums.length;
        if (l < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i <= l - 3; i++) {
            int j = i + 1;
            int k = l - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s < target) {
                    count += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}

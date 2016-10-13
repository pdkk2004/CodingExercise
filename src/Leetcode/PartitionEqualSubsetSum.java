package Leetcode;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % 2 == 1) {
            return false;
        }
        
        int half = sum / 2;
        boolean[][] S = new boolean[nums.length + 1][half + 1];
        
        S[0][0] = true;
        S[1][0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= half; j++) {
                S[i][j] = S[i - 1][j] || (j - nums[i - 1] >= 0 ? S[i - 1][j - nums[i - 1]]: false);
            }
        }
        return S[nums.length][half];
    }
}

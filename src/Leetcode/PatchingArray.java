package Leetcode;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {
        int i = 0, cnt = 0;
        long sum = 1;  // need to declare as long in case for integer overflow
        while (sum <= n) {
            if (i < nums.length && nums[i] <= sum) {
                sum += nums[i];
                i++;
            } else {
                cnt++;
                sum += sum;
            }
        }
        return cnt;
    }
}

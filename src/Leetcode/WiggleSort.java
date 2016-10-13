package Leetcode;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        boolean smallAhead = true;
        for (int i = 0; i < n; i++) {
            if (smallAhead && i < n - 1 && nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            } else if (!smallAhead && i < n - 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
            smallAhead = !smallAhead;
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

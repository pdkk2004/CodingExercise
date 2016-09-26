package Leetcode;

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] ret = new int[nums.length];
        int index = a >= 0 ? nums.length - 1 : 0;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (a >= 0) {
                ret[index--] = cal(nums[i], a, b, c) >= cal(nums[j], a, b, c) ? cal(nums[i++], a, b, c) : cal(nums[j--], a, b, c);
            } else {
                ret[index++] = cal(nums[i], a, b, c) >= cal(nums[j], a, b, c) ? cal(nums[j--], a, b, c) : cal(nums[i++], a, b, c);
            }
        }
        return ret;
    }
    
    private int cal(int v, int a, int b, int c) {
        return a * v * v + b * v + c;
    }
}

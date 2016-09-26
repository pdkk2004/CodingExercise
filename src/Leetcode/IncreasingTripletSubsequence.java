package Leetcode;

public class IncreasingTripletSubsequence {
	
    //O(n*n) approach
    public boolean increasingTriplet1(int[] nums) {
        int l = nums.length;
        if (l < 3) {
            return false;
        }
        
        int[] C = new int[l];
        C[0] = 1;
        for (int i = 1; i < l; i++) {
            C[i] = findMax(C, nums, i) + 1;
            if (C[i] == 3) {
                return true;
            }
        }
        return false;
    }
    
    private int findMax(int[] c, int[] values, int r) {
        int max = 0;
        for (int i = 0; i < r; i++) {
            if (values[i] < values[r] && max < c[i]) {
                max = c[i];
            }
        }
        return max;
    }
    
    //O(n) solution
    public boolean increasingTriplet(int[] nums) {
        int[] mins = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int num : nums) {
            if (num < mins[0]) {
                mins[0] = num;
            } else if (num > mins[0] && num < mins[1]) {
                mins[1] = num;
            } else if (num > mins[1]) {
                return true;
            }
        }
        return false;
    }
}

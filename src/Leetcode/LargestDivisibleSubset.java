package Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (nums.length <= 0) {
            return list;
        }
        int[] pre = new int[nums.length];
        int[] L = new int[nums.length];
        int max = 0;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            pre[i] = i;
            L[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && L[j] + 1 > L[i]) {
                    L[i] = L[j] + 1;
                    pre[i] = j;
                }  
            }
            if (L[max] < L[i]) {
                max = i;
            }
        }
        
        int end = max;
        while (pre[end] != end) {
            list.add(0, nums[end]);
            end = pre[end];
        }
        list.add(0, nums[end]);
        return list;
    }
}

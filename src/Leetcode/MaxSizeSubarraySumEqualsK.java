package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0;
        int len = 0;
        map.put(0, -1); //Note: Need to first add 0 for the case no number is selected yet.
        for (int i = 0; i < nums.length; i++) {
            s += nums[i];
            if (map.containsKey(s - k)) {
                len = Math.max(len, i - map.get(s - k));
            }
            map.putIfAbsent(s, i);
        }
        return len;
    }
}

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        ArrayList<Integer> r = new ArrayList<Integer>();
        int c = 0;
        for (int i : nums2) {
            if ((c = map.getOrDefault(i, 0)) > 0) {
                r.add(i);
                map.put(i, --c);
            }
        }
        int[] ret = new int[r.size()];
        for (int i = 0; i < r.size(); i++) {
            ret[i] = r.get(i);
        }
        return ret;
    }
}

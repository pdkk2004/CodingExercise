package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, true);
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i : nums2) {
            if (map.getOrDefault(i, false)) {
                ret.add(i);
                map.put(i, false);
            }
        }
        int[] array = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            array[i] = ret.get(i);
        }
        return array;
    }
}

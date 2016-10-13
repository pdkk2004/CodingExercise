package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutations {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int oddCnt = 0;
        for (Integer i : map.values()) {
            if (i % 2 != 0) {
                oddCnt++;
            }
            if (oddCnt > 1) {
                return false;
            }
        }
        return true;
    }
}

package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int b = 0, e = 0, max = 0, l = s.length();
        while (e < l) {
            char c = s.charAt(e);
            if (map.containsKey(c) || map.size() < k) {
                map.put(c, e);
            } else {
                char toRemove = findLastPosition(map);
                max = Math.max(e - b, max);
                b = map.get(toRemove) + 1;
                map.remove(toRemove);
                map.put(c, e);
            }
            e++;
        }
        max = Math.max(e - b, max);
        return max;
    }
    
    private char findLastPosition(Map<Character, Integer> map) {
        int min = Integer.MAX_VALUE;
        Character c = null;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() < min) {
                min = e.getValue();
                c = e.getKey();
            }
        }
        return c;
    }
}

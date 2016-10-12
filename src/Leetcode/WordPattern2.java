package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern2 {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> pMap = new HashMap<>();
        Set<String> mapped = new HashSet<>();
        return matchHelper(pattern, 0, str, 0, pMap, mapped);
    }
    
    private boolean matchHelper(String p, int pi, String s, int si, Map<Character, String> map, Set<String> set) {
        if (pi == p.length() && si == s.length()) {
            return true;
        }
        if (pi == p.length() || si == s.length()) {
            return false;
        }
        
        char pChar = p.charAt(pi);
        if (map.containsKey(pChar)) {
            String pStr = map.get(pChar);
            if (!s.startsWith(pStr, si)) {
                return false;
            } else {
                return matchHelper(p, pi + 1, s, si + pStr.length(), map, set);                
            }
        }
        
        for (int k = si + 1; k <= s.length(); k++) {
            String pStr = s.substring(si, k);
            if (set.contains(pStr)) {
                continue;
            }
            set.add(pStr);
            map.put(p.charAt(pi), pStr);
            if (matchHelper(p, pi + 1, s, k, map, set)) {
                return true;
            }
            map.remove(p.charAt(pi));
            set.remove(pStr);
        }
        return false;
    }
}

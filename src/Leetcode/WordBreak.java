package Leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreak {

    /*
    Backtracking approach. Exceed time limit.
    */
    public boolean wordBreakBacktrack(String s, Set<String> wordDict) {
          return backtrack(s, wordDict, new HashMap<String, Boolean>());      
    }
    
    private boolean backtrack(String s, Set<String> dict, Map<String, Boolean> mem) {
        if (dict.contains(s)) {
            return true;
        }
        if (mem.containsKey(s)) {
            return mem.get(s);
        }
        
        boolean isBreakable = false;
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                String postfix = s.substring(i);
                if (mem.containsKey(postfix)) {
                    isBreakable |= mem.get(postfix);
                } else {
                    isBreakable |= backtrack(postfix, dict, mem);
                }
            }
            if (isBreakable) {
                mem.put(s, true);
                break;
            }
        }
        return isBreakable;
    }
    
    //DP
    public boolean wordBreak(String s, Set<String> wordDict) {
        int l = s.length();
        boolean[] dp = new boolean[l + 1];
        dp[0] = true;
        
        int minLen = Integer.MAX_VALUE;
        int maxLen = 0;
        for (String wd : wordDict) {
            minLen = Math.min(minLen, wd.length());
            maxLen = Math.max(maxLen, wd.length());
        }
        
        for (int i = minLen; i <= l; i++) {
            for (int j = i - minLen; j >= 0 && j >= i - maxLen; j--) {
                dp[i] |= dp[j] && wordDict.contains(s.substring(j, i));
            }
        }
        
        return dp[l];
    }
}

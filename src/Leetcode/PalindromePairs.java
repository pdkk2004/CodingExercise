package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                String str1 = word.substring(0, j);
                String str2 = word.substring(j);
                if (isPal(str1)) {
                    String str2Rev = (new StringBuilder(str2)).reverse().toString();
                    int index = map.getOrDefault(str2Rev, -1);
                    if (index >= 0 && index != i) {
                        ArrayList<Integer> r = new ArrayList<Integer>();
                        r.add(index);
                        r.add(i);
                        ret.add(r);
                    }
                }
                
                if (str2.length() != 0 && isPal(str2)) {
                    String str1Rev = (new StringBuilder(str1)).reverse().toString();
                    int index = map.getOrDefault(str1Rev, -1);
                    if (index >= 0 && index != i) {
                        ArrayList<Integer> r = new ArrayList<Integer>();
                        r.add(i);
                        r.add(index);
                        ret.add(r);
                    }
                }
            }
        }
        
        return ret;
    }
    
    private boolean isPal(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l < r && str.charAt(l) == str.charAt(r)) {
            l++;
            r--;
        }
        return r <= l;
    }
}

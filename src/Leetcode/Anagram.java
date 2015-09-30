package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public ArrayList<String> anagrams(String[] strs) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        ArrayList<String> ret = new ArrayList<String>();
        
        for (String s : strs) {
            String sorted = sortStr(s);
            if (!map.containsKey(sorted)) {
                map.put(sorted, true);
            } else {
                if (map.get(sorted)) {
                    ret.add(s);
                    map.put(sorted, false);
                }
            }
        }
        return ret;
    }
    
    private String sortStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

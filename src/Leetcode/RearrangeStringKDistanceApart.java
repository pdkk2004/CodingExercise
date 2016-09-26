package Leetcode;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class RearrangeStringKDistanceApart {
    public String rearrangeString(String str, int k) {
        if (k < 2) {
            return str;
        }
        
        int[] occ = new int[26];
        SortedSet<int[]> set = new TreeSet<>((e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e2[0] - e1[0]);
        int length = str.length();
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            occ[c - 'a']++;;
        }
        
        for (int i = 0; i < occ.length; i++) {
            if (occ[i] != 0) {
                int[] pair = {occ[i], i};
                set.add(pair);
            }
        }
        
        char[] ret = new char[str.length()];
        int round = 0;
        int cur = round;
        Iterator<int[]> iter = set.iterator();
        while (iter.hasNext()) {
            int[] e = iter.next();
            for (int i = 0; i < e[0]; i++) {
                ret[cur] = (char)(e[1] + 'a');
                if (cur > 0 && ret[cur - 1] == ret[cur]) {
                    return "";
                }
                cur += k;
                if (cur >= str.length()) {
                    cur = ++round;
                }
            }
        }
        
        return new String(ret);
    }
}

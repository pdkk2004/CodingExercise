package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                char c = (char)('a' + (s.charAt(i) - s.charAt(i + 1) + 26) % 26);
                sb.append(c);
            }
            String p = sb.toString();
            if (!map.containsKey(p)) {
                map.put(p, new LinkedList<>());
            }
            map.get(p).add(s);
        }
        
        return new LinkedList<List<String>>(map.values());
    }
}

package Leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePermutation2 {
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int odd = -1;
        char[] chars = new char[s.length() / 2];
        int count = 0;
        for (char key : map.keySet()) {
            int n = map.get(key);
            if (n % 2 != 0) {
                if (odd != -1) {
                    return new LinkedList<>();
                }
                odd = (int)key;
            }
            for (int i = 0; i < n / 2; i++) {
                chars[count] = key;
                count++;
            }
        }
        
        List<String> ret = new LinkedList<>();
        permutation(chars, new boolean[chars.length], new StringBuilder(), ret, odd);
        return ret;
    }
    
    public void permutation(char[] chars, boolean[] visited, StringBuilder sb, List<String> ret, int odd) {
        if (sb.length() == chars.length) {
            String pre = sb.toString();
            if (odd >= 0) {
                pre = pre + (char)odd;
            }
            StringBuilder post = new StringBuilder(sb);
            ret.add(pre + post.reverse().toString());
            return;
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                sb.append(chars[i]);
                visited[i] = true;
                permutation(chars, visited, sb, ret, odd);
                visited[i] = false;
                sb.setLength(sb.length() - 1);
                while (i + 1 < chars.length && chars[i + 1] == chars[i]) {
                	i++;
                }
            }
        }
    }
}

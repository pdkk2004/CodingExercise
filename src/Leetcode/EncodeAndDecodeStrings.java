package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length() + "#" + str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            int ct = 0;
            while (i < s.length() && s.charAt(i) != '#') {
                ct = ct * 10 + (s.charAt(i) - '0');
                i++;
            }
            i++;
            ret.add(s.substring(i, i + ct));
            i += ct;
        }
        return ret;
    }
}

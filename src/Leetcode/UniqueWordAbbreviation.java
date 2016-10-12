package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueWordAbbreviation {
    
    private Map<String, Integer> dic;
    private Set<String> set;
    
    public UniqueWordAbbreviation(String[] dictionary) {
        this.dic = new HashMap<>();
        this.set = new HashSet<>();
        for (String s : dictionary) {
            if (!set.contains(s)) {
                set.add(s);
                String ab = abbre(s);
                dic.put(ab, dic.getOrDefault(ab, 0) + 1);
            }
        }
    }

    public boolean isUnique(String word) {
        String ab = abbre(word);
        int occurance = dic.getOrDefault(ab, 0);
        return occurance < 1 || (occurance == 1 && set.contains(word));
    }
    
    private String abbre(String word) {
        if (word.length() <= 2) {
            return word;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}

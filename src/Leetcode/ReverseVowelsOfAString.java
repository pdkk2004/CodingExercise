package Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
	
    public String reverseVowels(String s) {
        Character[] vowels = {'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        Set<Character> set = new HashSet<>(Arrays.asList(vowels));
        StringBuilder sb = new StringBuilder(s);
        int b = 0, e = sb.length() - 1;
        while (b < e) {
            while (b < e && !set.contains(sb.charAt(b))) {
                b++;
            }
            while (b < e && !set.contains(sb.charAt(e))) {
                e--;
            }
            if (b != e) {
                char temp = sb.charAt(b);
                sb.setCharAt(b, sb.charAt(e));
                sb.setCharAt(e, temp);
            }
            b++;
            e--;
        }
        return sb.toString();
    }
}

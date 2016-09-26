package Leetcode;

public class ReverseString {
	
    public String reverseString(String s) {
        int b = 0, e = s.length() - 1;
        char[] chars = s.toCharArray();
        while (b < e) {
            char temp = chars[b];
            chars[b] = chars[e];
            chars[e] = temp;
            b++;
            e--;
        }
        return new String(chars);
    }
}

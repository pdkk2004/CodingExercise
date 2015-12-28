package Leetcode;

/**
 * Solution:
 * http://bookshadow.com/weblog/2015/12/16/leetcode-maximum-product-word-lengths/
 * @author kkdpan
 *
 */
public class MaxProductOfWordLength {

    public int maxProduct(String[] words) {
        int[] bits = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            bits[i] = str2Bits(words[i]);
        }
        
        int max = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if ((bits[i] & bits[j]) == 0) {
                    max = Math.max(words[i].length() * words[j].length(), max);
                }
            }
        }
        return max;
    }
    
    private int str2Bits(String word) {
        int ret = 0;
        for (int i = 0; i < word.length(); i++) {
            int pos = word.charAt(i) - 'a';
            ret |= 1 << pos;
        }
        return ret;
    }
}

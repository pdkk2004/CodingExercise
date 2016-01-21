package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class BullsAndCows {

	/**
	 * One loop solution.
	 * @param secret
	 * @param guess
	 * @return
	 */
    public static String getHint(String secret, String guess) {
        Map<Character, Integer> s = new HashMap<>();
        ArrayList<String>[] graph = (ArrayList<String>[])new Object[10];
        
        int A = 0, B = 0;
        
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            if (c == secret.charAt(i)) {
                A++;
            } else {
            	char sChar = secret.charAt(i);
                s.put(sChar, s.getOrDefault(sChar, 0) + 1);
            }
        }
        
        for (int i = 0; i < guess.length(); i++) {
            char c = guess.charAt(i);
            int count = s.getOrDefault(c, 0);
            if ( count > 0) {
                if (secret.charAt(i) != c) {
                    s.put(c, --count);
                    B++;
                }
            }
        }
        return A + "A" + B + "B";
    }
    
    @Test
    public void test() {
    	Assert.assertEquals("0A0B", getHint("1", "0"));
    }
}

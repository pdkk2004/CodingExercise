package Leetcode;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AdditiveNumber {
	
	// Pay attention to edge cases:
	// 1)Integer overflow; 2) Invalid number format start with 0.
    public static boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        
        ArrayList<Long> seq = new ArrayList<Long>();
        return helper(num, 0, seq);
    }
    
    private static boolean helper(String num, int start, ArrayList<Long> seq) {
        if (start == num.length()) {
            return seq.size() >= 3;
        }
        
        for (int i = start + 1; i <= num.length(); i++) {
            String n = num.substring(start, i);
            
            // Handle 0 start invalid format
            if (n.charAt(0) == '0' && i - start > 1) {
                break;
            }
            
            //Handle big number overflow
            Long v = null;
            try {
            	v = Long.parseLong(n);
            } catch (NumberFormatException nfe) {
            	break;
            }
            
            if (seq.size() < 2 || seq.get(seq.size() - 1) + seq.get(seq.size() - 2) == v) {
                seq.add(v);
                if (helper(num, i, seq)) {
                    return true;
                }
                seq.remove(seq.size() - 1);
            } else if (seq.get(seq.size() - 1) + seq.get(seq.size() - 2) < v) {
                break;
            }
        }
        return false;
    }
    
    @Test
    public void test() {
    	String num = "11235813213455890144";
    	Assert.assertFalse(isAdditiveNumber(num));
    	
    	Assert.assertFalse(isAdditiveNumber("1023"));
    	
    	Assert.assertTrue(isAdditiveNumber("101"));

    }
}

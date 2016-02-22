package Leetcode;

import org.junit.Test;

public class PowerOf3 {

    public static boolean isPowerOfThree(int n) {
        int maxPower3 = (int)Math.pow(3, (int)(Math.log(0x7fffffff) / Math.log(3)));
        System.out.println(maxPower3);
        return n > 0 && (maxPower3 % n == 0);
    }
    
    @Test
    public void test() {
    	System.out.println(isPowerOfThree(27));
    	System.out.println(isPowerOfThree(45));

    }
}

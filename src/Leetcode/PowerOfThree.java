package Leetcode;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        // Calculate the largest number of pow 3 using log math calculation.
        // lgN / lg3 = log3(N)
        int maxPower3 = (int)Math.pow(3, (int)(Math.log(0x7fffffff) / Math.log(3)));
        return n > 0 && (maxPower3 % n == 0);
    }
}

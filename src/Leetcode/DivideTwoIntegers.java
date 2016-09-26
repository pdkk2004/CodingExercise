package Leetcode;

import org.junit.*;

public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException();
        }
        
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int ret = 0;
        
        while (dvd >= dvs) {
            long div = dvs;
            for (int i = 0; div <= dvd; div = div << 1, i++) {
                dvd -= div;
                ret += 1 << i;
            }
        }
        
        return (dividend ^ divisor) >>> 31 == 1 ? -ret : ret;
    }
    
    @Test
    public void test() {
    	int dividend = -2147483648;
    	int divisor = -1;
    	Assert.assertEquals(2147483647, divide(dividend, divisor));
    }
}

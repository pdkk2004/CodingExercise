package Leetcode;

public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int mod = n % 3;
        switch (mod) {
            case 0: return (int)Math.pow(3, n / 3);
            case 1: return 4 * (int)Math.pow(3, (n - 4) / 3);
            case 2: return 2 * (int)Math.pow(3, n / 3);
            default : throw new RuntimeException();
        }
    }
}

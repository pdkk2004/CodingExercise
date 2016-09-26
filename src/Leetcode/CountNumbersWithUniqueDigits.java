package Leetcode;

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int count = 0;
        if (n == 0) {
            return 1;
        }
        
        for (int i = 1; i <= n; i++) {
            int c = 1;
            if (i == 1) {
                c = 10;
            } else {
                int mul = 9;
                for (int j = 0; j < i; j++) {
                    c *= mul;
                    if (j >= 1) {
                        mul--;
                    }
                }
            }
            count += c;
        }
        return count;
    }
}

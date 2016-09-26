package Leetcode;

public class PowerOfFour {
	
    public boolean isPowerOfFour(int num) {
        boolean hasOne = false;
        int index = 0;
        if (num == 0) {
            return false;
        }
        while (num != 0) {
            index++;
            int v = num & 1;
            if (v == 1 && index % 2 == 0) {
                return false;
            } else if (v == 1 && index % 2 == 1) {
                if (hasOne) {
                    return false;
                } else {
                    hasOne = true;
                }
            }
            num >>>= 1;
        }
        return true;
    }
}

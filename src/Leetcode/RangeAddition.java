package Leetcode;

public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] data = new int[length];
        for (int[] op : updates) {
            data[op[0]] += op[2];
            if (op[1] < length - 1) {
                data[op[1] + 1] -= op[2];
            }
        }
        
        for (int i = 1; i < length; i++) {
            data[i] += data[i - 1];
        }
        return data;
    }
}

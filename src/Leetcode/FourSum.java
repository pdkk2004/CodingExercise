package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int l = num.length;
        if (l < 4) {
            return ret;
        }
        
        for (int i = 0; i <= l - 4; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j <= l - 3; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                
                int k = j + 1;
                int m = l - 1;
                while (k < m) {
                    int sum = num[i] + num[j] + num[k] + num[m];
                    if (sum == target) {
                        ret.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k], num[m])));
                        k++;
                        m--;
                        while (k < m && num[k] == num[k - 1]) {
                            k++;
                        }
                        while (m > k && num[m] == num[m + 1]) {
                            m--;
                        }
                    }else if (sum < target) {
                        k++;
                    } else {
                        m--;
                    }
                } 
            } 
        }
        return ret;
    }
}

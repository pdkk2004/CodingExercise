package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int l = num.length;
        Arrays.sort(num);
        for (int i = 0; i < l - 2 && num[i] <= 0; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }
            
            int j = i + 1;
            int k = l - 1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == 0) {
                    result.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k])));
                    j++;
                    k--;
                    while (j < k && num[j] == num[j - 1]) {
                        j++;
                    }
                    while (j < k && num[k] == num[k + 1]) {
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}

package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ret = new LinkedList<>();
        getFactorHelper(n, 2, new LinkedList<Integer>(), ret);
        return ret;
    }
    
    private void getFactorHelper(int n, int factor, LinkedList<Integer> r, List<List<Integer>> ret) {
        if (n == 1) {
            if (r.size() > 1) {
                ret.add(new LinkedList<Integer>(r));
            }
            return;
        }
        
        for (int i = factor; i <= n; i++) {
            if (n % i == 0) {
                r.add(i);
                getFactorHelper(n / i, i, r, ret);
                r.removeLast();
            }
        }
    }
}

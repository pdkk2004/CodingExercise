package Leetcode;

import java.util.Iterator;
import java.util.List;

import Common.NestedInteger;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        Iterator<NestedInteger> iter = nestedList.iterator();
        return helper(iter, 1);
    }
    
    private int helper(Iterator<NestedInteger> iter, int depth) {
        int sum = 0;
        while (iter.hasNext()) {
            NestedInteger ni = iter.next();
            if (ni.isInteger()) {
                sum += ni.getInteger() * depth;
            } else {
                sum += helper(ni.getList().iterator(), depth + 1);
            }
        }
        return sum;
    }
}

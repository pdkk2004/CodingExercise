package Leetcode;

import java.util.LinkedList;
import java.util.List;

import Common.NestedInteger;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedListWeightSum2 {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }
    
    private int helper(List<NestedInteger> num, int pre) {
        int intSum = pre;
        List<NestedInteger> nextLevel = new LinkedList<>();
        for (NestedInteger ni : num) {
            if (ni.isInteger()) {
                intSum += ni.getInteger();
            } else {
                nextLevel.addAll(ni.getList());
            }
        }
        
        
        int listSum = 0;
        if (!nextLevel.isEmpty()) {
            listSum = helper(nextLevel, intSum);
        }
        
        return listSum + intSum;
    }
}

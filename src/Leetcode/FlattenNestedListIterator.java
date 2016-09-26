package Leetcode;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

import Common.NestedInteger;

public class FlattenNestedListIterator implements Iterator<Integer>{
    
    private Stack<ListIterator<NestedInteger>> stack;
    private ListIterator<NestedInteger> iter;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<ListIterator<NestedInteger>>();
        iter = nestedList.listIterator();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return iter.next().getInteger();
        } else {
            throw new RuntimeException("");
        }
    }

    @Override
    public boolean hasNext() {
        if (iter.hasNext()) {
            NestedInteger ni = iter.next();
            if (ni.isInteger()) {
                iter.previous();
                return true;
            } else {
                stack.push(iter);
                iter = ni.getList().listIterator();
            }
        } else {
            if (!stack.isEmpty()) {
                iter = stack.pop();
            } else {
                return false;
            }
        }
        return hasNext();
    }
}

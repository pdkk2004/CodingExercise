package Leetcode;

import java.util.Iterator;
import java.util.List;

public class Flatten2DVector implements Iterator<Integer> {
    private Iterator<List<Integer>> iterators;
    private Iterator<Integer> iter;
    
    public Flatten2DVector(List<List<Integer>> vec2d) {
        this.iterators = vec2d.iterator();
        while (iterators.hasNext()) {
            iter = iterators.next().iterator();
            if (iter.hasNext()) {
                break;
            }
        }
    }

    @Override
    public Integer next() {
        Integer ret = iter.next();
        while (!iter.hasNext() && iterators.hasNext()) {
            iter = iterators.next().iterator();
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        return iter != null && iter.hasNext();
    }
}

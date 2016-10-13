package Leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator {

    private Queue<Iterator<Integer>> queue;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.queue = new LinkedList<>();
        if (v1.size() > 0) {
            queue.offer(v1.iterator());
        }
        if (v2.size() > 0) {
            queue.offer(v2.iterator());
        }
    }

    public int next() {
        if (!hasNext()) {
            throw new RuntimeException();
        }
        
        Iterator<Integer> it = queue.poll();
        int r = it.next();
        if (it.hasNext()) {
            this.queue.offer(it);
        }
        return r;
    }

    public boolean hasNext() {
        return !this.queue.isEmpty();
    }
}

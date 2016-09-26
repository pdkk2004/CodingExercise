package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    private static class Tuple implements Comparable<Tuple>{
        private int v;
        private int freq;
        
        public Tuple(int v, int freq) {
            this.v = v;
            this.freq = freq;
        }
        
        public Tuple(int v) {
            this.v = v;
            freq = 0;
        }
        
        public int compareTo(Tuple t) {
            return this.freq - t.freq;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Tuple> map = new HashMap<>();
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            Tuple t = map.get(nums[i]);
            if (t == null) {
                t = new Tuple(nums[i]);
                map.put(nums[i], t);
            }
            t.freq += 1;
        }
        
        for (int key : map.keySet()) {
            Tuple tup = map.get(key);
            if (minHeap.size() < k) {
                minHeap.offer(tup);
            } else if (minHeap.peek().freq < tup.freq) {
                minHeap.poll();
                minHeap.offer(tup);
            }
        }
        
        List<Integer> ret = new ArrayList<Integer>();
        while (!minHeap.isEmpty()) {
            ret.add(minHeap.poll().v);
        }
        return ret;
    }
}

package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 * O(num of edge) Solution: http://www.cnblogs.com/grandyang/p/5000291.html
 * @author kkdpan
 *
 */
public class MinimumHeightTrees {

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] numConn = new int[n];
        List<Integer> ret = new LinkedList<Integer>();
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int[] tuple = edges[i];
            graph.get(tuple[0]).add(tuple[1]);
            numConn[tuple[0]]++;
            graph.get(tuple[1]).add(tuple[0]);
            numConn[tuple[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (numConn[i] == 1) {
                queue.offer(i);
            }
        }
        
        while (n > 2) {
        	int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int delete = queue.poll();
                n--;
                for (int nb : graph.get(delete)) {
                    numConn[nb]--;
                    if (numConn[nb] == 1) {
                        queue.offer(nb);
                    }
                }
            }
        }
        
        while (!queue.isEmpty()) {
            ret.add(queue.poll());
        }
        
        return ret;
    }
    
    @Test
    public void test() {
    	int[][] edges = {{1,0},{1,2},{1,3}};
    	List<Integer> ret = findMinHeightTrees(4, edges);
    	Assert.assertEquals(1, ret.size());
    	Assert.assertTrue(ret.get(0) == 1);
    }
}

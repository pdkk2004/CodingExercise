package Leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTree {
    
    private static class Node {
        private int val;
        private int parent;
        private int rank;
        
        private Node(int v) {
            this.val = v;
            this.parent = v;
            this.rank = 0;
        }
    }
    
    public static class UFS {
        
        private Map<Integer, Node> map;
        private int size;
        
        public UFS() {
            this.map = new HashMap<>();
            this.size = 0;
        }
        
        public UFS(List<Integer> vals) {
            this();
            for (int i : vals) {
                makeSet(i);
            }
        }
        
        public void makeSet(int val) {
            if (!map.containsKey(val)) {
                Node node = new Node(val);
                map.put(val, node);
                this.size++;
            }
        }
        
        public Integer findSet(int val) {
            if (!map.containsKey(val)) {
                return null;
            }
            Node node = map.get(val);
            while (node.parent != node.val) {
                Node pNode = map.get(node.parent);
                node.parent = pNode.parent;
                node = pNode;
            }
            return node.val;
        }
        
        public void union(int v1, int v2) {
            Integer set1 = findSet(v1);
            Integer set2 = findSet(v2);
            if (set1 == null || set2 == null || set1 == set2) {
                return;
            }
            Node n1 = map.get(set1);
            Node n2 = map.get(set2);
            if (n1.rank > n2.rank) {
                n2.parent = n1.val;
            } else {
                if (n1.rank == n2.rank) {
                    n2.rank++;
                }
                n1.parent = n2.val;
            }
            size--;
        }
        
        public int size() {
            return size;
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        UFS ufs = new UFS();
        for (int i = 0; i < n; i++) {
            ufs.makeSet(i);
        }
        
        for (int[] edge : edges) {
            if (ufs.findSet(edge[0]) == ufs.findSet(edge[1])) {
                return false;
            } else {
                ufs.union(edge[0], edge[1]);
            }
        }
        return ufs.size == 1;
    }
}

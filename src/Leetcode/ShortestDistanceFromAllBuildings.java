package Leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceFromAllBuildings {
    
    private class Pair {
        int x;
        int y;
        
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            } else if (!(o instanceof Pair)) {
                return false;
            } else {
                Pair p = (Pair)o;
                return this.x == p.x && this.y == p.y;
            }
        }
        
        public int hashCode() {
            return this.x * 177 + this.y;
        }
    }
    
    private static int[][] OFFSET = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; 
    
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return -1;
        }
        int n = grid[0].length;
        
        int[][] reachable = new int[m][n];
        
        int min = Integer.MIN_VALUE;
        int bNums = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bNums++;
                    bfs(grid, i, j, m, n, reachable);
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0 && reachable[i][j] == bNums && grid[i][j] > min) {
                    min = grid[i][j];
                }
            }
        }
        return min == Integer.MIN_VALUE ? -1 : -min;
    }
    
    private void bfs(int[][] grid, int i, int j, int m, int n, int[][] reachable) {
        Queue<Pair> queue = new LinkedList<>();
        Queue<Pair> nextQueue = new LinkedList<>();
        int dist = -1;
        Set<Pair> visited = new HashSet<>();
        Pair start = new Pair(i, j);
        queue.offer(new Pair(i, j));
        visited.add(start);
        
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int k = 0; k < OFFSET.length; k++) {
                int x_i = p.x + OFFSET[k][0];
                int y_i = p.y + OFFSET[k][1];
                if (x_i < 0 || x_i >= m || y_i < 0 || y_i >= n || grid[x_i][y_i] > 0) {
                    continue;
                }
                Pair adj = new Pair(x_i, y_i);
                if (!visited.contains(adj)) {
                    visited.add(adj);
                    nextQueue.offer(adj);
                    grid[x_i][y_i] += dist;
                    reachable[x_i][y_i]++;
                }
             }
             if (queue.isEmpty()) {
                 dist -= 1;
                 Queue<Pair> tmp = queue;
                 queue = nextQueue;
                 nextQueue = tmp;
             }
        }
    }
}

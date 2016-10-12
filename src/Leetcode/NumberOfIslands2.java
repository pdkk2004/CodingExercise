package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class NumberOfIslands2 {
	   int[] roots;
	    int count = 0;
	    
	    public List<Integer> numIslands2(int m, int n, int[][] positions) {
	        List<Integer> ret = new LinkedList<>();
	        int[][] grid = new int[m][n];
	        roots = new int[m * n];
	        for (int i = 0; i < m * n; i++) {
	            roots[i] = i;
	        }
	        
	        for (int[] p : positions) {
	            int x = p[0];
	            int y = p[1];
	            int r = x * n + y;
	            grid[x][y] = 1;
	            count++;
	            
	            if (y > 0 && grid[x][y - 1] > 0) {
	                union(roots, r, r - 1);
	            }
	            
	            if (x > 0 && grid[x - 1][y] > 0) {
	                union(roots, r, r - n);
	            }
	            
	            if (y < n - 1 && grid[x][y + 1] > 0) {
	                union(roots, r, r + 1);
	            }
	            
	            if (x < m - 1 && grid[x + 1][y] > 0) {
	                union(roots, r, r + n);
	            }
	            
	            ret.add(count);
	        }
	        
	        return ret;
	    }
	    
	    private int find(int[] roots, int i) {
	        while (roots[i] != i) {
	            roots[i] = roots[roots[i]];
	            i = roots[i];
	        }
	        
	        return i;
	    }
	    
	    private void union(int[] roots, int i, int j) {
	        int iRoot = find(roots, i);
	        int jRoot = find(roots, j);
	        if (iRoot != jRoot) {
	            count--;
	            roots[iRoot] = jRoot;
	        }
	    }
}

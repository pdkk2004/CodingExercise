package MiscQuestions;

import java.util.PriorityQueue;

/**
 * Trapping rain water II.
 * Solution from: http://www.cnblogs.com/easonliu/p/4743644.html
 * @author kkdpan
 *
 */
public class TrappingRainWater2D {
	
	private static class Cell implements Comparable<Cell> {
		private int ht;
		private int x;
		private int y;
		
		public Cell(int h, int x, int y) {
			this.ht = h;
			this.x = x;
			this.y = y;
		}
		
		
		public int compareTo(Cell o) {
			return this.ht - o.ht;
		}
	}
	
	public int trapRainWater(int[][] grid) {
		int m = grid.length;
		if (m == 0) {
			return 0;
		}
		int n = grid[0].length;
		
		PriorityQueue<Cell> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[m][n];
		
		for (int j = 0; j < n; j++) {
			pq.offer(new Cell(grid[0][j], 0, j));
			visited[0][j] = true;
			pq.offer(new Cell(grid[m - 1][j], 0, j));
			visited[m - 1][j] = true;
		}
		
		for (int i = 0; i < m; i++) {
			pq.offer(new Cell(grid[i][0], i, 0));
			visited[i][0] = true;
			pq.offer(new Cell(grid[i][n - 1], i, n - 1));
			visited[i][n - 1] = true;
		}
		
		int total = 0;
		int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		while (!pq.isEmpty()) {
			Cell c = pq.poll();
			for (int i = 0; i < offset.length; i++) {
				int x = c.x + offset[i][0];
				int y = c.y + offset[i][1];
				if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
					//Note: pay attention to here. Need to update height use higher surronding height.
					pq.offer(new Cell(Math.max(c.ht, grid[x][y]), x, y));  
					visited[x][y] = true;
					total += Math.max(0, c.ht - grid[x][y]);
				}
			}
		}
		return total;
	}
}

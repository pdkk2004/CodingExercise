package MiscQuestions;

import java.util.PriorityQueue;

public class ShortestWaterFlow {

	/**
	 * From 1point3acres. Google interview question:
	 * http://www.1point3acres.com/bbs/thread-191771-2-1.html
	 * @param heights
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 * @return
	 */
	public int shortestWaterFlow(int[][] heights, int sx, int sy, int ex, int ey) {
		int highest = Integer.MAX_VALUE;
		int[][] offset = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		int m = heights.length;
		int n = heights[0].length;
		boolean[][] visited = new boolean[m][n];
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((x1, x2) -> x1[2] - x2[2]);
		pq.offer(new int[]{sx, sy, heights[sx][sy]});
		visited[sx][sy] = true;
		while (!pq.isEmpty()) {
			int[] bar = pq.poll();
			highest = Math.max(highest, bar[2]);
			for (int[] o : offset) {
				int x = bar[0] + o[0];
				int y = bar[1] + o[1];
				if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
					if (x == ex && y == ey) {
						return Math.max(highest, heights[x][y]) + 1;
					}
					pq.offer(new int[]{x, y, heights[x][y]});
					visited[x][y] = true;
				}
			}
		}
		
		return highest + 1;
	}
}

package MiscQuestions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.fgdsb.com/2015/01/03/police-and-rooms/
 * @author dipa
 *
 */
public class PoliceAndRooms {
	
	private static class Pair {
		private int x;
		private int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[][] policeDistance(int[][] matrix) {
		int m = matrix.length;
		if (m == 0) {
			return matrix;
		}
		int n = matrix[0].length;
		
		int[][] ret = new int[m][n];
		Queue<Pair> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					queue.add(new Pair(i, j));
				}
				ret[i][j] = matrix[i][j];
			}
		}
		
		int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			for (int i = 0; i < delta.length; i++) {
				int newX = p.x + delta[i][0];
				int newY = p.y + delta[i][1];
				if ( newX < 0 || newX >= m || newY < 0 || newY >= n || matrix[newX][newY] <= 0) {
					continue;
				}
				
				if (matrix[newX][newY] == Integer.MAX_VALUE) {
					ret[newX][newY] = ret[p.x][p.y] + 1;
					queue.offer(new Pair(newX, newY));
				}
			}
		}
		return ret;
	}
}

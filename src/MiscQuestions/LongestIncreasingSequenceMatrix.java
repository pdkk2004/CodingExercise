package MiscQuestions;

import java.util.Arrays;

import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/07/longest-increasing-sequence-in-matrix/
 * @author kkdpan
 *
 */
public class LongestIncreasingSequenceMatrix {

	private static class Pair {
		int x;
		int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} 
	
	public static int[] longestIncreasingSequence(int[][] matrix) {
		int m = matrix.length;
		if (m == 0) {
			return new int[0];
		}
		int n = matrix[0].length;
		
		int mem[][] = new int[m][n];
		
		int maxStart = 0, maxLength = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int l = dfs(matrix, m, n, i, j, mem);
				if (maxLength < l) {
					maxStart = matrix[i][j];
					maxLength = l;
				}
			}
		}
		
		int[] ret = new int[maxLength];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = maxStart++;
		}
		return ret;
	}
	
	private static int dfs(int[][] matrix, int m, int n, int i, int j, int[][] mem) {
		if (i < 0 || i >= m || j < 0 || j >= n) {
			return 0;
		}
		
		if (mem[i][j] != 0) {
			return mem[i][j];
		}
		
		Pair[] delts = {new Pair(-1, 0), new Pair(0, 1), new Pair(1, 0), new Pair(0, -1)};
		
		int max = 1;
		for (Pair delt : delts) {
			int x = i + delt.x;
			int y = j + delt.y;
			if (x < 0 || x >= m || y < 0 || y >= n) {
				continue;
			}
			if (matrix[x][y] == matrix[i][j] + 1) {
				max = Math.max(max, 1 + dfs(matrix, m, n, x, y, mem));
			}
		}
		mem[i][j] = max;
		return max;
	}
	
	@Test
	public void test() {
		int[][] matrix = {{1, 2, 3, 4}, {8, 7, 6, 5}};
		int[] sequence = longestIncreasingSequence(matrix);
		
		System.out.println(Arrays.toString(sequence));
	}
}

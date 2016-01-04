package MiscQuestions;

import org.junit.Test;

import org.junit.*;

/**
 * http://www.fgdsb.com/2015/02/16/maximum-sum-rectangle-in-matrix/
 * @author dipa
 *
 */
public class MaximumSumRectangleInMatrix {
	
	public static int max(int[][] array) {
		int r = array.length;
		if (r == 0) {
			return 0;
		}
		int c = array[0].length;
		
		int[][] columnSum = new int[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				columnSum[i][j] = i == 0 ? 0 : columnSum[i - 1][j] + array[i][j];
			}
		}
		
		int ret = Integer.MIN_VALUE;
		for (int re = 0; re < r; re++) {
			for (int rb = 0; rb <= re; rb++) {
				int m = Integer.MIN_VALUE;
				int sum = 0;
				for (int j = 0; j < c; j++) {
					int v = columnSum[re][j] - (rb == 0 ? 0 : columnSum[rb - 1][j]);
					if (sum < 0) {
						sum = v;
					} else {
						sum += v;
					}
					m = Math.max(m, sum);
				}
				ret = Math.max(ret,  m);
			}
		}
		return ret;
	}
	
	@Test
	public void test() {
		int[][] array = { { 1, 2, -1, -4, -20 }, { -8, -3, 4, 2, 1 }, { 3, 8, 10, 1, 3 }, { -4, -1, 1, 7, -6 } };
		Assert.assertEquals(29, max(array));
	}
	
}

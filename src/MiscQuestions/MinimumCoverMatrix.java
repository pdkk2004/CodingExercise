package MiscQuestions;

import org.junit.Assert;
import org.junit.Test;

public class MinimumCoverMatrix {

	public static int minCoverMatrix(char[][] matrix) {
		int row = matrix.length;
		if (row == 0) {
			return 0;
		}
		int col = matrix[0].length;
		
		int width = 1;
		for (int i = 0; i < row; i++) {
			width = lcm(width, getRowMinCover(matrix[i]));
		}
		
		int height = 1;
		for (int i = 0; i < col; i++) {
			height = lcm(height, getColumnMinCover(matrix, row, i));
		}
		
		return height * width;
	}
	
	private static int getRowMinCover(char[] array) {
		int l = array.length;
		int[] next = new int[l + 1];
		next[0] = -1;
		
		int j = -1, i = 0;
		while (i < l) {
			if (j == -1 || array[i] == array[j]) {
				i++;
				j++;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
		return l - next[l];
	}
	
	private static int getColumnMinCover(char[][] matrix, int rNum, int col) {
		int[] next = new int[rNum + 1];
		next[0] = -1;
		int j = -1, i = 0;
		while (i < rNum) {
			if (j == -1 || matrix[i][col] == matrix[j][col]) {
				i++;
				j++;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
		return rNum - next[rNum];
	}
	
	private static int lcm(int a, int b) {
		int product = a * b;
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		while (a % b != 0) {
			int mod = a % b;
			a = b;
			b = mod;
		}
		return product / b;
	}
	
	@Test
	public void test() {
		char[][] matrix = {{'A', 'B', 'A', 'B', 'A'}, {'A', 'B', 'A', 'B', 'A'}};
		Assert.assertEquals(2, minCoverMatrix(matrix));
	}
	
	@Test
	public void testlcm() {
		Assert.assertEquals(24, lcm(12, 8));
	}
}

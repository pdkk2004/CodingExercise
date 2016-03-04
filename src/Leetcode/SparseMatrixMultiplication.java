package Leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Leetcode: Sparse Matrix Multiplication.
 * @author dipa
 *
 */
public class SparseMatrixMultiplication {
	
	public static int[][] matrixMultiplication(int[][] A, int[][] B) {
		int rA = A.length;
		int cA = A[0].length;
		int rB = B.length;
		int cB = B[0].length;
		
		if (cA != rB) {
			throw new IllegalArgumentException();
		}
		
		int[][] ret = new int[rA][cB];
		
		for (int i = 0; i < rA; i++) {
			for (int j = 0; j < cB; j++) {
				int num = 0;
				for (int k = 0; k < cA; k++) {
					num += A[i][k] * B[k][j];
				}
				ret[i][j] = num;
			}
		}
		
		return ret; 
	}
	
	@Test
	public void test() {
		int[][] A = {{1, 0, 0}, {-1, 0, 3}};
		int[][] B = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
		
		int[][] ret = matrixMultiplication(A, B);
		Assert.assertArrayEquals(new int[]{7, 0, 0}, ret[0]);
		Assert.assertArrayEquals(new int[]{-7, 0, 3}, ret[1]);
	}
}

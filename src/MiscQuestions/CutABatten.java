package MiscQuestions;

import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/03/cut-a-batten/
 * @author kkdpan
 *
 */
public class CutABatten {
	
	public static int getMinCost(int[] array) {
		int l = array.length;
		if (l < 3) {
			return 0;
		}
		
		int[][] C = new int[l][l];
		for (int i = 2; i < l; i++) {
			for (int j = 0; j < l - i; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = 1; k < i; k++) {
					min = Math.min(min, C[j][j + k] + C[j + k][j + i] + array[j + i] - array[j]);
				}
				C[j][j + i] = min;
			}
		}
		return C[0][l - 1];
	}
	
	@Test
	public void test() {
//		int[] array = {0, 3, 7, 8, 11, 12};
		int[] array = {0, 3, 7, 8};

		System.out.println(getMinCost(array));
	}
}

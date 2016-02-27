package MiscQuestions;

import org.junit.Test;

import org.junit.Assert;

/**
 * http://www.fgdsb.com/2015/01/10/cutting-a-rod/
 * @author kkdpan
 *
 */
public class CuttingRod {

	public static int cuttingRod(int n, int[] prices) {
		int[] P = new int[n + 1];
		if (n <= 0) {
			return 0;
		}
		
		for (int i = 1; i <= n; i++) {
			int max = prices[i - 1];  //Note: Initialize max to be prices[i - 1], which means no cut.
			for (int j = 1; j < i; j++) {
				max = Math.max(max, P[i - j] + prices[j - 1]);
			}
			P[i] = max;
		}
		return P[n];
	}
	
	@Test
	public void test() {
		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		Assert.assertEquals(22, cuttingRod(8, prices));
	}
}

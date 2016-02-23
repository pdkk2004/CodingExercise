package MiscQuestions;

import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/10/maximum-product-cutting/
 * @author kkdpan
 *
 */
public class MaxProductCutting {

	public static int maxProductCutting(int n) {
		int P[] = new int[n + 1];
		if (n <= 1) {
			throw new IllegalArgumentException();
		}
		
		P[2] = 1;
		for (int i = 3; i <= n; i++) {
			P[i] = 0;
			for (int j = 1; j < i; j++) {
				int m = Math.max((i - j) * j, j * P[i - j]);
				P[i] = Math.max(P[i], m);
			}
		}
		return P[n];
	}
	
	@Test
	public void test() {
		Assert.assertEquals(1, maxProductCutting(2));
		Assert.assertEquals(2, maxProductCutting(3));
		Assert.assertEquals(12, maxProductCutting(7));
	}
}

package MiscQuestions;

import org.junit.Test;

import org.junit.Assert;

/**
 * http://www.fgdsb.com/2015/01/04/fence-painter/
 * @author kkdpan
 * DP: T[n] = (k - 1) * (T[n - 1] + T[n - 2])
 */
public class FencePainter {
	
	public static int numberOfPainting(int n, int k) {
		if (n == 0 || k == 0) {
			return 0;
		}
		
		int n_2 = k, n_1 = k * k;
		for (int i = 0; i < n - 1; i++) {
			int n_0 = (k - 1) * n_1 + (k - 1) * n_2;
			n_2 = n_1;
			n_1 = n_0;
		}
		return n_2;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(1, numberOfPainting(2, 1));
		Assert.assertEquals(0, numberOfPainting(3, 1));
		Assert.assertEquals(4, numberOfPainting(2, 2));
		Assert.assertEquals(6, numberOfPainting(3, 2));
		Assert.assertEquals(9, numberOfPainting(2, 3));
		Assert.assertEquals(24, numberOfPainting(3, 3));
	}
}

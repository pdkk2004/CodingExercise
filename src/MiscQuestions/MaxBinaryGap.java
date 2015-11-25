package MiscQuestions;

import org.junit.Test;

import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/03/max-binary-gap/
 * @author kkdpan
 *
 */
public class MaxBinaryGap {

	public static int maxBineryGap(int num) {
		int max = 0;
		int c = -1;
		while (num != 0) {
			int dig = num & 1;
			if (dig == 0) {
				if (c >= 0) {
					c++;
				}
			} else {
				max = Math.max(c, max);
				c = 0;
			}
			num >>>= 1;
		}
		return max;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(2, maxBineryGap(9));
	}
}

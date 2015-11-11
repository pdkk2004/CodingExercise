package MiscQuestions;

import org.junit.Assert;
import org.junit.Test;

public class XTimes7 {

	/**
	 * http://www.fgdsb.com/2015/01/12/x-times-seven/
	 * @param n
	 * @return
	 */
	public static int times7(int n) {
		return add(n << 2, add(n << 1, n));
	}
	
	private static int add(int a, int b) {
		int sum = 0, carry = 0;
		do {
			sum = a ^ b;
			carry = (a & b) << 1;
			a = sum;
			b = carry;
		} while (b != 0);
		return a;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(56, times7(8));
		Assert.assertEquals(-56, times7(-8));
		
		int i = -1;
		i = i << 1;
		System.out.println(i);
	}
}

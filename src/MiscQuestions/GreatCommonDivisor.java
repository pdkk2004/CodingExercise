package MiscQuestions;

import org.junit.*;

public class GreatCommonDivisor {
	
	public static int GCD(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		while (b != 0) {
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(1, GCD(1, 5));
		Assert.assertEquals(1, GCD(2, 5));
		Assert.assertEquals(3, GCD(6, 9));
	}
}

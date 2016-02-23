package Leetcode;

import org.junit.*;

public class SuperUglyNumber {

	public static int nthSuperUglyNumber(int n, int[] primes) {
		int[] uglyNums = new int[n + 1];
		int[] index = new int[primes.length];
		int i = 1;
		uglyNums[0] = 1;

		while (i <= n) {
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int j = 0; j < primes.length; j++) {
				int v = uglyNums[index[j]] * primes[j];
				if (v < min) {
					min = v;
					minIndex = j;
				}
			}

			index[minIndex]++;

			if (min != uglyNums[i - 1]) { //NOTE: Need to remove duplicate when min is equal to previous ugly number.
				uglyNums[i] = min;
				i++;
			}
		}

		return uglyNums[n - 1];
	}

	@Test
	public void test() {
		int[] primes = { 2, 7, 13, 19 };
		Assert.assertEquals(16, nthSuperUglyNumber(8, primes));
	}
}

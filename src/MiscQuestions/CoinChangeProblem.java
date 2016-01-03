package MiscQuestions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Stopwatch;

/**
 * http://www.fgdsb.com/2015/01/03/coin-change-problem/
 * @author kkdpan
 *
 */
public class CoinChangeProblem {

	public int minCoins(int[] coins, int t) {
		if (t < 0) {
			throw new IllegalArgumentException();
		}
		int m = coins.length;
		int[] T = new int[t + 1];
		
		for (int i = 1; i <= t; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				if (i >= coins[j] && T[i - coins[j]] >= 0) {
					min = Math.min(min, T[i - coins[j]] + 1);
				} else {
					break;
				}
			}
			T[i] = min == Integer.MAX_VALUE ? -1 : min;
		}
		return T[t];
	}
	
	/**
	 * Note iterative way to count how many ways to make change is tricky.
	 * Need to first loop through coins, then loop through target money.
	 * @param coins
	 * @param t
	 * @return
	 */
	public int countWaysIterative(int[] coins, int t) {
		if (t < 0) {
			throw new IllegalArgumentException();
		}
		
		int n = coins.length;
		int[] W = new int[t + 1];
		W[0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = coins[i]; j <= t; j++) {
				W[j] += W[j - coins[i]];
			}
		}
		return W[t];
	}
	
	public int countWaysRec(int[] coins, int t) {
		if (t < 0) {
			throw new IllegalArgumentException();
		}
		return countHelper(coins, 0, t);
	}
	
	private int countHelper(int[] coins, int index, int t) {
		if (t == 0) {
			return 1;
		}
		
		int c = 0;
		for (int i = index; i < coins.length; i++) {
			if (t < coins[i]) {
				break;
			}
			c += countHelper(coins, i, t - coins[i]);
		}
		return c;
	}
	
	@Test
	public void testCount() {
		int[] coins = {1, 5, 10, 25};
		
		Stopwatch sw = Stopwatch.createStarted();
		int expected = countWaysIterative(coins, 77);
		sw.stop();
		System.out.println("Iterative:" + sw.elapsed(TimeUnit.MICROSECONDS));
		sw.reset();
		sw.start();
		int actual = countWaysRec(coins, 77);
		sw.stop();
		System.out.println("Recursive:" + sw.elapsed(TimeUnit.MICROSECONDS));
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testEdgeCase() {
		int[] coins = {2};
		Assert.assertEquals(-1, minCoins(coins, 3));
	}
}

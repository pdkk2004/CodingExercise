package MiscQuestions;

import java.util.Arrays;

import org.junit.*;

/**
 * 
 * @author dipa
 *
 */
public class CoinChangeProglem {
	
	public static int minCoins(int[] coins, int target) {
		Arrays.sort(coins);
		int[] C = new int[target + 1];
		for (int i = 1; i <= target; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length && i >= coins[j]; j++) {
				min = Math.min(min, C[i - coins[j]] + 1);
			}
			C[i] = min;
		}
		return C[target];
	}
	
	/**
	 * Backtracking approach to find how many ways to make changes for a given value.
	 * @param coins
	 * @param target
	 * @return
	 */
	public static int numOfWaysBacktracking(int[] coins, int target) {
		Arrays.sort(coins);
		return numOfWaysHelper(coins, 0, target);
	}
	
	private static int numOfWaysHelper(int[] coins, int start, int target) {
		if (target == 0) {
			return 1;
		}
		
		int count = 0;
		for (int i = start; i < coins.length && coins[i] <= target; i++) {
			int left = target - coins[i];
			count += numOfWaysHelper(coins, i, left);
		}
		return count;
	}
	
	/**
	 * Iterative way to find how many ways to make changes for a given value.
	 * @param coins
	 * @param target
	 * @return
	 */
	public static int numOfWaysIterative(int[] coins, int target) {
		Arrays.sort(coins);
		int[] ways = new int[target + 1];
		
		// Base case, if given target is 0, there is 1 way.
		ways[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= target; j++) {
				ways[j] += ways[j - coins[i]];
			}
		}
		return ways[target];
	}
	
	@Test
	public void test() {
		int[] coins = {1, 5, 10, 25};
		Assert.assertEquals(numOfWaysBacktracking(coins, 77), numOfWaysIterative(coins, 77));
	}
}

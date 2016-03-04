package Leetcode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.*;

/**
 * Leetcode: Maximum Size Subarray Sum Equals k.
 * @author dipa
 *
 */
public class MaximumSizeSubarraySumEqualsK {
	
	public static int maxSizeSubarray(int[] nums, int k) {
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1); //NOTE: Initialize the (0, -1) if the subarray starts from beginning.
		int maxLength = 0;
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int pre = map.getOrDefault(sum - k, Integer.MAX_VALUE);
			maxLength = Math.max(maxLength, i - pre);
			map.putIfAbsent(sum, i);
		}
		return maxLength;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(4, maxSizeSubarray(new int[]{1, -1, 5, -2, 3}, 3));
		Assert.assertEquals(2, maxSizeSubarray(new int[]{-2, -1, 2, 1}, 1));
	}
}

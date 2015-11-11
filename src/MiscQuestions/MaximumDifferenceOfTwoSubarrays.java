package MiscQuestions;

import org.junit.Test;

import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/05/max-dif-of-two-subarrays/
 * @author dipa
 * Note: Application of Leetcode Maximum Subarray problem.
 */
public class MaximumDifferenceOfTwoSubarrays {
	
	public static int solution(int[] array) {
		int l = array.length;
		if (l <= 0) {
			return 0;
		}

		int maxSum = 0;
		int minSum = 0;
		int MAX = Integer.MIN_VALUE;
		int MIN = Integer.MAX_VALUE;
		
		int[] leftMax = new int[l];
		int[] leftMin = new int[l];
		
		for (int i = 0; i < l; i++) {
			if (maxSum > 0) {
				maxSum += array[i];
			} else {
				maxSum = array[i];
			}
			leftMax[i] = Math.max(maxSum, MAX);

			if (minSum < 0) {
				minSum += array[i];
			} else {
				minSum = array[i];
			}
			leftMin[i] = Math.min(minSum, MIN);
		}
		
		maxSum = 0;
		minSum = 0;
		MAX = Integer.MIN_VALUE;
		MIN = Integer.MAX_VALUE;
		
		int[] rightMax = new int[l];
		int[] rightMin = new int[l];
		
		for (int i = l - 1; i >= 0; i--) {
			if (maxSum > 0) {
				maxSum += array[i];
			} else {
				maxSum = array[i];
			}
			rightMax[i] = Math.max(maxSum, MAX);
			
			if (minSum < 0) {
				minSum += array[i];
			} else {
				minSum = array[i];
			}
			rightMin[i] = Math.min(minSum, MIN);
		}
		
		int maxDiff = 0;
		for (int i = 0; i < l - 1; i++) {
			maxDiff = Math.max(maxDiff, Math.abs(leftMax[i] - rightMin[i + 1]));
			maxDiff = Math.max(maxDiff, Math.abs(leftMin[i] - rightMax[i + 1]));
		}
		return maxDiff;
	}
	
	@Test
	public void test() {
		int[] array = { 2, -1, -2, 1, -4, 2, 8 };
		Assert.assertEquals(16, solution(array));
	}
}

package Leetcode;

public class MaximumSubarray {
	
	public static int solution(int[] array) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int n : array) {
			if (sum >= 0) {
				sum += n;
			} else {
				sum = n;
			}
			max = Math.max(sum, max);
		}
		return max;
	}
}

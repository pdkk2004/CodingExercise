package Leetcode;

/*
 * Leetcode question:
 * Discussion & Solution:
 * https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
 */
public class BurstBalloons {

	public int burstBalloons(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] paddedNums = new int[nums.length + 2];
		int len = paddedNums.length;
		
		for (int i = 1; i < len - 1; i++) {
			paddedNums[i] = nums[i - 1];
		}
		paddedNums[0] = 1;
		paddedNums[len - 1] = 1;
		
		int[][] C = new int[len][len];
		
		for (int k = 2; k < len; k++) {
			for (int l = 0; l < len - k; l++) {
				int r = l + k;
				for (int m = l + 1; m < r; m++) {
					C[l][r] = Math.max(C[l][r], paddedNums[l] * paddedNums[m] * paddedNums[r] + C[l][m] + C[m][r]);
				}
			}
		}
		
		return C[0][len - 1];
	}
}

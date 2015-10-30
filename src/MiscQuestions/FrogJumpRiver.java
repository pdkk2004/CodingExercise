package MiscQuestions;

import java.util.Arrays;

/**
 * http://www.fgdsb.com/2015/01/19/jump-river/
 * @author kkdpan
 *
 */
public class FrogJumpRiver {
	
	public static boolean canJumpCross(int[] stones) {
		return canJumpHelper(stones, 0, 0);
	}
	
	private static boolean canJumpHelper(int[] stones, int start, int speed) {
		if (start >= stones.length - 1) {
			return true;
		}
		
		for (int i = -1; i <= 1; i++) {
			int sp = speed + i;
			if (sp > 0) {
				int nextStone = stoneExists(stones, start + 1, sp);
				if (nextStone >= 0 && canJumpHelper(stones, nextStone, sp)) {
					return true;
				}
			}
		}
		return false;
	}
	
	private static int stoneExists(int[] stones, int index, int steps) {
		for (int i = index; i < stones.length && stones[index - 1] + steps >= stones[i]; i++) {
			if (stones[index - 1] + steps == stones[i]) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Find the minimual jumps needed to jump cross river.
	 * @param Each element in the array means a position in the river,
	 *  where 1 means a stone exist and 0 means not.
	 * @return
	 */
	public static int findMinJumpSteps(int[] stones) {
		int len = stones.length;
		if (len <= 1) {
			return 0;
		}
		
		int[][] J = new int[len][len];
		for (int i = 0; i < len; i++) {
			J[i][0] = Integer.MAX_VALUE;
		}
		Arrays.fill(J[0], Integer.MAX_VALUE);
		J[0][1] = 0;
		
		for (int i = 1; i < len; i++) {
			for (int j = 1; j < len; j++) {
				if (stones[i] == 0) {
					J[i][j] = Integer.MAX_VALUE;
				} else {
					J[i][j] = i - j >= 0 ? J[i - j][j] + 1 : Integer.MAX_VALUE;
					int m = i - j + 1 >= 0 ? J[i - j + 1][j - 1] + 1 : Integer.MAX_VALUE;
					J[i][j] = Math.min(J[i][j], m);
				}
			}
		}
		
		int ret = Integer.MAX_VALUE;
		for (int j = 0; j < len; j++) {
			ret = Math.min(ret, J[len][j]);
		}
		return ret;
	}
}

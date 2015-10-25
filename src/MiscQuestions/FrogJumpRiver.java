package MiscQuestions;

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
}

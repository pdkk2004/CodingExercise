package MiscQuestions;

import org.junit.Test;

import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/04/min-num-distance/
 * @author dipa
 *
 */
public class MinimumNumberDistance {

	public static int solution(int[] array, int x, int y) {
		int foundPos = -1;
		
		int minDist = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] != x && array[i] != y) {
				continue;
			}
			if (foundPos >= 0 && array[foundPos] != array[i]) {
				minDist = Math.min(i - foundPos, minDist);
			}
			foundPos = i;
		}
		return minDist;
	}
	
	@Test
	public void test() {
		int[] arr = {2, 5, 3, 5, 4, 4, 2, 3};
		Assert.assertEquals(1, solution(arr, 4, 5));
	}
}

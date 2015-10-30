package MiscQuestions;

import org.junit.Assert;

/**
 * http://www.fgdsb.com/2015/01/19/max-length-of-the-loop/
 * @author kkdpan
 *
 */
public class MaxLenghOfLoop {
	
	public static int maxLenghOfLoop(int[] array) {
		boolean[] visited = new boolean[array.length];
		int[] steps = new int[array.length];
		int maxLoop = 0;
		for (int i = 0; i < array.length && !visited[i]; i++) {
			int index = i;
			int step = 0;
			while (index >= 0 && index < array.length) {
				step++;
				steps[index] = step;
				visited[index] = true;
				index = array[index];
				if (visited[index]) {
					maxLoop = Math.max(maxLoop, step - steps[index] + 1);
					break;
				}
			}
		}
		return maxLoop;
	}
	
	public static void main(String[] args) {
		Assert.assertEquals(5, maxLenghOfLoop(new int[]{1, 2, 3, 4, 0}));
		Assert.assertEquals(4, maxLenghOfLoop(new int[]{3, 5, 1, 6, 2, 4, 0}));
		Assert.assertEquals(1, maxLenghOfLoop(new int[]{2, 2, 2, 2}));
		Assert.assertEquals(3, maxLenghOfLoop(new int[]{3, 2, 1, 4, 0}));
		Assert.assertEquals(3, maxLenghOfLoop(new int[]{1, 2, 3, 4, 2, 0}));
	}
}

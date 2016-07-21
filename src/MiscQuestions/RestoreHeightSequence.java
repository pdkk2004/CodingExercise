package MiscQuestions;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class RestoreHeightSequence {
	
	/**
	 * From Google interview question:
	 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=140258
	 * @param heights
	 * @param pos
	 * @return
	 */
	public int[] restoreHeightSequence(int[] heights, int[] pos) {
		int n = heights.length;
		int[] ret = new int[n];
		Integer[] index = new Integer[n];
		for (int i = 0; i < n; i++) {
			index[i] = i;
		}
		Arrays.sort(index, (i1, i2) -> (heights[i1] == heights[i2] ? pos[i1] - pos[i2] : heights[i1] - heights[i2]));
		for (int i = 0; i < n; i++) {
			int p = pos[index[i]];
			int j = 0;
			while (j < n) {
				if (ret[j] == 0) {
					p--;
				}
				if (p < 0) {
					break;
				}
				j++;
			}
			if (j == n) {
				throw new IllegalArgumentException("Input is invalid.");
			}
			ret[j] = heights[index[i]];
		}
		return ret;
		
	}
	
	@Test
	public void test() {
		int[] restored = restoreHeightSequence(new int[]{6, 2, 8, 1, 5}, new int[]{0, 1, 0, 3, 2});
		System.out.println(Arrays.toString(restored));
		Assert.assertArrayEquals(new int[]{6, 2, 8, 1, 5}, restored);
		
		restored = restoreHeightSequence(new int[]{1, 2, 3, 4, 5}, new int[]{0, 0, 0, 0, 0});
		Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, restored);

		restored = restoreHeightSequence(new int[]{3, 5, 1, 2, 4}, new int[]{0, 0, 0, 2, 0});
		System.out.println(Arrays.toString(restored));
		Assert.assertArrayEquals(new int[]{1, 3, 4, 2, 5}, restored);

	}
	
}

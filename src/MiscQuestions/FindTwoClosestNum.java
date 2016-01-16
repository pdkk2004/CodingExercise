package MiscQuestions;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://www.mitbbs.com/article_t/JobHunting/33124223.html
 * Question 2.
 * @author kkdpan
 *
 */
public class FindTwoClosestNum {

	public static int[] find2ClosestNum(int[] array, int t) {
		int l = array.length;
		if (l <= 1 && t < 0) {
			throw new IllegalArgumentException("");
		}
		Arrays.sort(array);
		int i = 0, j = 1;
		int minDiff = Integer.MAX_VALUE;
		int[] ret = new int[2];
		while (i < j && j < l) {
			int df = Math.abs(array[j] - array[i] - t);
			if (minDiff > df) {
				minDiff = df;
				ret[0] = array[i];
				ret[1] = array[j];
			}
			if (array[j] - array[i] < t) {
				j++;
			} else {
				i++;
			}
			if (i == j) {
				j++;
			}
		}
		return ret;
	}
	
	@Test
	public void test() {
		int[] array = {55, 99, 6, 29, 1, 523, 3};
		Assert.assertArrayEquals(new int[]{1, 3},  find2ClosestNum(array, 0));
		Assert.assertArrayEquals(new int[]{29, 99},  find2ClosestNum(array, 69)); 

	}
}

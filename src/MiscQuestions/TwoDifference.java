package MiscQuestions;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/06/two-difference/
 * @author dipa
 *
 */
public class TwoDifference {
	
	public int[] twoDifference(int[] array, int target) {
		if (array == null || array.length < 2) {
			throw new IllegalArgumentException();
		}
		
		int[] ret = new int[2];
		for (int p1 = 0, p2 = 1; p2 < array.length;) {
			int d = array[p2] - array[p1];
			if (d == target) {
				ret[0] = array[p1];
				ret[1] = array[p2];
				break;
			} else if (d < target) {
				p2++;
			} else {
				p1++;
			}
			
			//Note: Special case need to handle when p1 == p2. Because p1 == p2 is not a valid case for two difference!!
			if (p1 == p2) {
				p2++;
			}
		}
		return ret;
	}
	
	@Test
	public void test() {
		int[] array = {1, 3, 4, 5, 7, 9, 10, 15, 22, 34};
		
		int[] expected = {3, 10};
		Assert.assertArrayEquals(expected, twoDifference(array, 7));
		
		int[] expected1 = {4, 22};
		Assert.assertArrayEquals(expected1, twoDifference(array, 18));
	}
}

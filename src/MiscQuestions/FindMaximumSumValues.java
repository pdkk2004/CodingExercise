package MiscQuestions;

import org.junit.Test;

import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/03/find-max-values/
 * Same question as houses robbery
 * @author dipa
 *
 */
public class FindMaximumSumValues {
	
	public static int maxSumValues(int[] array) {
		int l = array.length;
		if (l == 0) {
			return 0;
		}
		
		int pre = array[0], prePre = 0;
		for (int i = 1; i < l; i++) {
			int m = Math.max(pre, prePre + array[i]);
			prePre = pre;
			pre = m;
		}
		return pre;
	}
	
	@Test
	public void test() {
		int[] test1 = {3, 2, 7, 10};
		Assert.assertEquals(13, maxSumValues(test1));
		
		int[] test2 = {3, 2, 5, 10, 7};
		Assert.assertEquals(15, maxSumValues(test2));
		
		int[] test3 = {1, 5, 4, 3, 2};
		Assert.assertEquals(8, maxSumValues(test3));
	}
}

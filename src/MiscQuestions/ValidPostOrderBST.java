package MiscQuestions;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/03/valid-postorder-traversal-of-bst/
 * @author kkdpan
 *
 */
public class ValidPostOrderBST {

	public static boolean validPostOrderBST(int[] array) {
		return helper(array, 0, array.length - 1);
	}
	
	private static boolean helper(int[] array, int l, int r) {
		if (array == null) {
			return false;
		}
		
		if (l >= r) {
			return true;
		}
		
		int left = l;
		while (left < r && array[left] <= array[r]) {
			left++;
		}
		int right = left;
		while (right < r) {
			if (array[right] <= array[r]) {
				return false;
			}
			right++;
		}
		
		return helper(array, l, left - 1) && helper(array, left, r - 1);
	}
	
	@Test
	public void test() {
		int[] input = {5,7,6,9,11,10,8};
		int[] input1 = {7,4,6,5};
		int[] input3 = {5,7,7,6,9,9,11,10,8};
		Assert.assertFalse(validPostOrderBST(input1));
		Assert.assertTrue(validPostOrderBST(input));
		Assert.assertTrue(validPostOrderBST(input3));
	}
}

package MiscQuestions;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/17/segregate-even-and-odd/
 * @author kkdpan
 *
 */
public class SegregateEvenAndOddNumber {

	public static void segregate(int[] nums) {
		int l = nums.length;
		int i = -1, j = 0;
		while (j < l) {
			if (nums[j] % 2 == 0) {
				swap(nums, ++i, j);
			}
			j++;
		}
	}

	private static void swap(int[] array, int a, int b) {
		if (a != b) {
			int temp = array[a];
			array[a] = array[b];
			array[b] = temp;
		}
	}
	
	@Test
	public void test() {
		int[] array = {12, 34, 45, 9, 8, 90, 3};
		System.out.println(Arrays.toString(array));
		segregate(array);
		System.out.println(Arrays.toString(array));
		Assert.assertArrayEquals(new int[]{12, 34, 8, 90, 45, 9, 3}, array);
		
		
	}
}

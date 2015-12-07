package MiscQuestions;

import java.util.Arrays;

import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/03/find-three-increasing-subsequence/
 * @author dipa
 *
 */
public class FindThreeIncreasingSubsequence {
	
//	public static int[] findThreeIncreasingSubsequence(int[] array) {
//		int l = array.length;
//		int first = 0, second = -1, mid = 0;
//		for (int i = 1; i < l; i++) {
//			if (second == -1) {
//				if (array[i] > array[first]) {
//					second = i;
//				} else {
//					first = i;
//				}
//			} else if (array[i] > array[second]) {
//				return new int[]{array[first], array[second], array[i]};
//			} else if (array[i] > array[first]) {
//				first = mid;
//				second = i;
//			}
//		}
//		return new int[]{};
//	}
	
	public static int[] findThreeIncreasingSubsequence(int[] array) {
		if (array == null || array.length < 3) {
			return new int[]{};
		}
		int l = array.length;
		int[] leftMin = new int[l];
		leftMin[0] = -1;
		int min = array[0];
		for (int i = 1; i < l; i++) {
			leftMin[i] = min;
			min = Math.min(min, array[i]);
		}
		
		int max = array[l - 1];
		for (int i = l - 2; i >= 0; i--) {
			if (array[i] < max && array[i] > leftMin[i]) {
				return new int[]{leftMin[i], array[i], max};
			} else {
				max = Math.max(max, array[i]);
			}
		}
		return new int[]{};
	}
	
	@Test
	public void test() {
		int[] array = {4,7,5,1,3,8,9,6,2};
		System.out.println(Arrays.toString(findThreeIncreasingSubsequence(array)));
	}
}

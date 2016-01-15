package MiscQuestions;

import org.junit.Test;

import org.junit.*;

/**
 * Question & Solution:
 * Sol 1: Use enhanced merge sort solution.
 * Sol 2: Use AVL Binary Search tree. Insert element array[i] one by one, and count the number of node that smaller than array[i] during traverse.
 * http://www.geeksforgeeks.org/counting-inversions/
 * @author kkdpan
 *
 */
public class InversionCount {
	
	public static int countInversions(int[] array) {
		return countInversionsHelper(array, 0, array.length - 1);
	}
	
	private static int countInversionsHelper(int[] array, int b, int e) {
		if (b < e) {
			int mid = b + ( e - b ) / 2;
			int left = countInversionsHelper(array, b, mid);
			int right = countInversionsHelper(array, mid + 1, e);
			return left + right + merge(array, b, mid, e);
		} else {
			return 0;
		}
	}
	
	private static int merge(int[] array, int b, int m, int e) {
		int i = b, j = m + 1;
		int[] buffer = new int[e - b + 1];
		int invCount = 0;
		int c = 0;
		while (i <= m && j <= e) {
			if (array[i] > array[j]) {
				invCount += m - i + 1;
				buffer[c++] = array[j++];
			} else {
				buffer[c++] = array[i++];
			}
		}
		
		if (i <= m) {
			System.arraycopy(array, i, buffer, c, m - i + 1);
		}
		
		if (j <= e) {
			System.arraycopy(array, j, buffer, c, e - j + 1);
		}
		
		System.arraycopy(buffer, 0, array, b, e - b + 1);
		return invCount;
	}
	
	@Test
	public void test() {
		int[] array = {2, 4, 1, 3, 5};
		Assert.assertEquals(3, countInversions(array));
	}
	
}

package MiscQuestions;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class RotatedSortedArray {
	
	public static int[] rotate(int[] array, int k) {
		int l = array.length;
		k = k % l;
		if (k == 0) {
			return array;
		}
		
		for (int i = 1; i <= k; i++) {
			int temp = array[l - 1];
			for (int j = l - 2; j >= 0; j--) {
				array[j + 1] = array[j];
			}
			array[0] = temp;
		}
		
		return array;
	}
	
	public static int[] rotate1(int[] array, int k) {
		int l = array.length;
		k = k % l;
		
		reverse(array, 0, l - 1);
		reverse(array, 0, k - 1);
		reverse(array, k, l - 1);
		return array;
	}
	
	private static void reverse(int[] array, int b, int e) {
		if (b < 0 || e >= array.length || b >= e) {
			return;
		}
		
		while (b < e) {
			int temp = array[b];
			array[b] = array[e];
			array[e] = temp;
			b++;
			e--;
		}
	}
	
	@Test
	public void test() {
		int[] array = {1, 2, 3, 4, 5};
		int[] array1 = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(rotate(array, 2)));
		System.out.println(Arrays.toString(rotate1(array1, 2)));
		Assert.assertArrayEquals(array, array1);
	}
}

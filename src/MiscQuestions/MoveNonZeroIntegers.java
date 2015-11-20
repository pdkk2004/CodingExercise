package MiscQuestions;

import java.util.Arrays;

import org.junit.Test;

/**
 * http://www.fgdsb.com/2015/01/03/move-non-zero-integers/
 * @author kkdpan
 *
 */
public class MoveNonZeroIntegers {

	public static void move(int[] array) {
		int l = array.length;
		int i = 0, j = 0;
		while (j < l) {
			if (array[j] != 0) {
				swap(array, i++, j);
			}
			j++;
		}
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	@Test
	public void test() {
		int[] array = {1, 5, 0, 6, 0, 10, 0, 9, 0, 0, 25};
		System.out.println(Arrays.toString(array));
		move(array);
		System.out.println(Arrays.toString(array));
	}
}

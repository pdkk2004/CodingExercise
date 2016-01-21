package MiscQuestions;

import java.util.Arrays;

import org.junit.Test;

public class WigglySort2 {

	public static void sort(int[] array) {
		sort(array, 0, true);
	}
	
	private static void sort(int[] array, int start, boolean smallAhead) {
		if (start >= array.length - 1) {
			return;
		}
		
		int i = start;
		while (i < array.length - 1) {
			if (array[i] == array[i + 1]) {
				sort(array, i + 1, !smallAhead);
			}
			if (smallAhead && array[i] > array[i + 1] || !smallAhead && array[i] < array[i + 1]) {
				int temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
			}
			smallAhead = !smallAhead;
			i++;
		}
	}
	
	@Test
	public void test() {
		int[] nums = {1,2,2,1,2,1,1,1,1,2,2,2};
		sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}

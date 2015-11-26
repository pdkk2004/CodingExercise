package MiscQuestions;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.Test;

import org.junit.*;

public class MaxAndMin {
	
	public static int[] maxAndMin(int[] array) {
		int l = array.length;
		int[] ret = new int[2];

		int i = 0;
		while (i < l - 1){
			if (array[i] > array[i + 1]) {
				ret[0] = Math.max(ret[0], array[i]);
				ret[1] = Math.min(ret[1], array[i + 1]);
			} else {
				ret[0] = Math.max(ret[0], array[i + 1]);
				ret[1] = Math.min(ret[1], array[i]);
			}
			i += 2;
		}
		
		if (i < l) {
			ret[0] = Math.max(ret[0], array[i]);
			ret[1] = Math.min(ret[1], array[i]);
		}
		return ret;
	}
	
	@Test
	public void test() {
		int[] testArray = {3, 5, 1, 8, 10, 15, 15, 0, 20, 25, 17, 14, 1};
		int max = Arrays.stream(testArray).max().getAsInt();
		int min = Arrays.stream(testArray).min().getAsInt();
		int[] ret = maxAndMin(testArray);
		Assert.assertEquals(max, ret[0]);
		Assert.assertEquals(min, ret[1]);
	}
}

package MiscQuestions;

import java.util.Arrays;

import org.junit.Test;

public class FindRandomIndexOfMaxValue {
	
	public static int findRandomIndexOfMaxValue(int[] array) {
		int l = array.length;
		int max = Integer.MIN_VALUE;
		int count = 0;
		
		if (l == 0) {
			throw new IllegalArgumentException();
		}
		
		int ret = 0;
		for (int i = 0; i < l; i++) {
			if (array[i] > max) {
				max = array[i];
				count = 1;
			} else if (array[i] == max) {
				count++;
			} else {
				continue;
			}
			if (Math.floor(Math.random() * count) == 0) {
				ret = i;
			}
		}

		return ret;
	}
	
	@Test
	public void test() {
		int[] array = {1, 5, 7, 3, 2, 2, 3, 7, 7};
		
		System.out.println(Arrays.toString(array));
		System.out.println();
		
		int ret1 = 0, ret2 = 0, ret3 = 0;
		for (int i = 0; i < 5000; i++) {
			int pos = findRandomIndexOfMaxValue(array);
			if ( pos == 2) {
				ret1++;
			} else if ( pos == 7){
				ret2++;
			} else {
				ret3++;
			}
		}
		
		System.out.println("Ret1 count:" + ret1 + ", Ret2 count:" + ret2 + ", Ret3 count:" + ret3);
	}
}

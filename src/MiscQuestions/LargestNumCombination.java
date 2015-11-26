package MiscQuestions;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import org.junit.*;

/**
 * 
 * @author kkdpan
 *
 */
public class LargestNumCombination {
	
	public static int largestNumCombination(int[] array) {
		Integer[] arrayInteger = ArrayUtils.toObject(array);
		
		Arrays.sort(arrayInteger, (x1, x2) -> combine(x2, x1) - combine(x1, x2));
		
		int ret = arrayInteger[0];
		for (int i = 1; i < arrayInteger.length; i++) {
			ret = combine(ret, arrayInteger[i]);
		}
		return ret;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(910, largestNumCombination(new int[]{10, 9}));
		Assert.assertEquals(78532, largestNumCombination(new int[]{2, 3, 5, 78}));
		Assert.assertEquals(9100, largestNumCombination(new int[]{100, 9}));
		Assert.assertEquals(78781532, largestNumCombination(new int[]{2, 3, 5, 78, 781}));
	}
	
	private static int combine(int a, int b) {
		int ret = a;
		int bCopy = b;
		int digits = 0;
		while (b > 0) {
			digits++;
			b /= 10;
		}
		return (int)(ret * Math.pow(10, digits) + bCopy);
	}
}

package MiscQuestions;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/10/find-longest-contiguous-subarray-sum-to-zero/
 * @author dipa
 *
 */
public class FindLongestContiguousSubarraySumToZero {

	public int[] findSubarraySumToZero(int[] array) {
		int l = array.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int maxLength = 0, start = 0;
		for (int i = 0; i < l; i++) {
			sum += array[i];
			int prev = map.getOrDefault(sum, -1);
			if (prev >= 0) {
				int length = i - prev;
				if (length > maxLength) {
					maxLength = length;
					start = prev + 1;
				}
			}else {
				map.put(sum, i);
			}
		}
		int[] ret = new int[maxLength];
		System.arraycopy(array, start, ret, 0, maxLength);
		return ret;
	}
	
	@Test
	public void test() {
		int[] array = {1, 2, 3, 4, 5};
		int[] ret = findSubarraySumToZero(array);
		Assert.assertEquals(0, ret.length);
	}
	
	@Test
	public void test1() {
		int[] array = {};
		int[] ret = findSubarraySumToZero(array);
		Assert.assertEquals(0, ret.length);
	}
}

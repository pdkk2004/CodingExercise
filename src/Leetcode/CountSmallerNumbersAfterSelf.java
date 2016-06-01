package Leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CountSmallerNumbersAfterSelf {
	
	public static List<Integer> countSmaller(int[] nums) {
		Integer[] ret = new Integer[nums.length];
		Arrays.fill(ret, 0);
		mergeSort(nums, 0, nums.length - 1, ret);
		return Arrays.asList(ret);
	}

	private static void mergeSort(int[] nums, int start, int end, Integer[] count) {
		if (start >= end) {
			return;
		}

		int m = start + (end - start) / 2;
		mergeSort(nums, start, m, count);
		mergeSort(nums, m + 1, end, count);
		merge(nums, start, m, end, count);
	}

	private static void merge(int[] nums, int b, int m, int e, Integer[] count) {
		if (b < 0 || e >= nums.length || b > e) {
			return;
		}

		int[] buffer = new int[e - b + 1];

		int i = b, j = m + 1, c = 0;
		while (i <= m && j <= e) {
			while (j <= e && nums[i] > nums[j]) {
				buffer[c++] = nums[j++];
			}
			if (j <= e) {
				count[i] = j - m;
				buffer[c++] = nums[i++];
			}
			
		}

		while (i <= m) {
			buffer[c++] = nums[i];
			count[i++] += e - m;
		}

		if (j <= e) {
			System.arraycopy(nums, j, buffer, c, e - j + 1);
		}
		
		System.arraycopy(buffer, 0, nums, b, e - b + 1);
	}
	
	@Test
	public void test() {
		int[] nums = {5,2,6,1};
		
		List<Integer> ret = countSmaller(nums);
		System.out.println(ret.toString());
	}
}

package Leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import org.junit.*;

public class CountSmallerNumbersAfterSelf {
	
	public List<Integer> countSmaller(int[] nums) {
		int l = nums.length;
		int[] index = new int[l];
		Integer[] counts = new Integer[l];

		for (int i = 0; i < l; i++) {
			index[i] = i;
			counts[i] = 0;
		}

		countHelper(nums, index, counts, 0, l - 1);
		return Arrays.asList(counts);
	}

	private void countHelper(int[] nums, int[] index, Integer[] counts, int b, int e) {
		if (b < e) {
			int m = b + (e - b) / 2;
			countHelper(nums, index, counts, b, m);
			countHelper(nums, index, counts, m + 1, e);
			merge(nums, index, counts, b, e);
		}
	}

	private void merge(int[] nums, int[] index, Integer[] counts, int b, int e) {
		int m = b + (e - b) / 2;
		int[] temp = new int[e - b + 1];
		int i = b, j = m + 1;
		int c = 0;
		while (i <= m && j <= e) {
			if (nums[index[i]] > nums[index[j]]) {
				counts[index[i]] += e - j + 1;
				temp[c] = index[i];
				i++;
			} else {
				temp[c] = index[j];
				j++;
			}
			c++;
		}
		while (i <= m) {
			temp[c++] = index[i++];
		}
		while (j <= e) {
			temp[c++] = index[j++];
		}
		System.arraycopy(temp, 0, index, b, c);
	}
	
	@Test
	public void test() {
		int[] nums = {5,2,6,1};
		
		List<Integer> ret = countSmaller(nums);
		System.out.println(ret.toString());
		
		Integer[] expected = {2,1,1,0};
		Assert.assertEquals(ret, Arrays.asList(expected));
	}
}

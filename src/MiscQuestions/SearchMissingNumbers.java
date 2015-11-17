package MiscQuestions;

import java.util.ArrayList;

import org.junit.Test;

public class SearchMissingNumbers {
	
	public static ArrayList<Integer> searchMissingNumbers(int[] nums, int m) {
		int l = nums.length;
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (l - 1 - 0 == nums[l - 1] - nums[0] && m != 0) {
			for (int i = 1; i < nums[0]; i++) {
				ret.add(i);
			}
			for (int j = 1; j <= m - ret.size(); j++) {
				ret.add(nums[l - 1] + j);
			}
		}
		
		return helper(nums, 0, nums.length - 1, m);
	}
	
	private static ArrayList<Integer> helper(int[] nums, int b, int e, int m) {
		ArrayList<Integer> ret = new ArrayList<Integer>();
		if (m == 0 || b > e || b < 0 || e >= nums.length || nums[e] - nums[b] == e - b) {
			return ret;
		}

		if (b + 1 == e){
			for (int i = 1; i <= m; i++) {
				ret.add(nums[b] + i);
			}
		}
				
		int mid = b + (e - b) / 2;
		int leftMiss = nums[mid] - nums[b] - (mid - b);
		int rightMiss = nums[e] - nums[mid] - (e - mid);
		ArrayList<Integer> left = helper(nums, b, mid, leftMiss);
		ArrayList<Integer> right = helper(nums, mid, e, rightMiss);
		left.addAll(right);
		return left;
	}
	
	@Test
	public void test() {
		int[] arr = {1, 2, 4, 5, 6, 8};
		System.out.println(searchMissingNumbers(arr, 2));
		
		int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println(searchMissingNumbers(arr1, 0));
		
		int[] arr2 = {2, 3, 4, 5, 6, 7, 8};
		System.out.println(searchMissingNumbers(arr2, 1));
	}
}

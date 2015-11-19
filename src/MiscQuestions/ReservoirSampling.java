package MiscQuestions;

import java.util.Arrays;

import org.junit.Test;

public class ReservoirSampling {

	public static int[] reservoirSampling(int[] nums, int k) {
		int n = nums.length;
		int[] ret = new int[k];
		int i = 0;
		while (i < n && i < k) {
			ret[i] = nums[i];
			i++;
		}
		
		while (i < n) {
			int r = (int)(Math.random() * (i + 1));
			if (r < k) {
				ret[r] = nums[i];
			}
			i++;
		}
		return ret;
	}
	
	@Test
	public void test() {
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println(Arrays.toString(reservoirSampling(nums, 4)));
		System.out.println(Arrays.toString(reservoirSampling(nums, 4)));
		System.out.println(Arrays.toString(reservoirSampling(nums, 4)));
		System.out.println(Arrays.toString(reservoirSampling(nums, 4)));
		System.out.println(Arrays.toString(reservoirSampling(nums, 4)));
	}
}

package Leetcode;

import Common.BinaryIndexTree;

public class RangeSumQueryMutableBITTree {
	
	private BinaryIndexTree BIT;
	
	private int[] nums;
	
	public RangeSumQueryMutableBITTree(int[] array) {
		this.nums = array;
		this.BIT = new BinaryIndexTree(array);
	}
	
	public void update(int i, int val) {
		BIT.add(i + 1, val - nums[i]);
		nums[i] = val;
	}
	
	public int sumRange(int i, int j) {
		return BIT.sum(j + 1) - BIT.sum(i);
	}
	
}

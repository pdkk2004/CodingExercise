package Leetcode;

public class RangeSumQueryMutable {

	private static class SegmentNode {
		private int start;
		private int end;
		private int sum;
		private SegmentNode left;
		private SegmentNode right;

		public SegmentNode(int start, int end, int sum) {
			this.start = start;
			this.end = end;
			this.sum = sum;
		}
	}

	public RangeSumQueryMutable(int[] nums) {
	        
	    }

	void update(int i, int val) {

	}

	public int sumRange(int i, int j) {
		
	}

	private SegmentNode buildTree(int[] nums, int left, int right) {
		if (left < 0 || right >= nums.length || left > right) {
			return null;
		}

		if (left == right) {
			return new SegmentNode(nums[left], left, right);
		}

		int middle = left + (right - left) / 2;
		SegmentNode leftTree = buildTree(nums, left, middle);
		SegmentNode rightTree = buildTree(nums, middle + 1, right);
		int sum = (leftTree == null ? 0 : leftTree.sum) + (rightTree == null ? 0 : rightTree.sum);
		SegmentNode ret = new SegmentNode(sum, left, right);
		ret.left = leftTree;
		ret.right = rightTree;
		return ret;
	}

	private void update(int i, int v, SegmentNode root) {
		if (root == null || i < root.start || i > root.end) {
			return;
		}

		if (root.left == root.right && i == root.start) {
			root.sum = v;
		} else if (i >= root.left && i <= root.right) {

		}
	}

	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.update(1, 10);
	// numArray.sumRange(1, 2);
}

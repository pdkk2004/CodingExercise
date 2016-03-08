package Leetcode;

/**
 * Range Sum Query Mutable. 
 * Use Segment Tree. http://www.cnblogs.com/Liok3187/p/4978027.html
 * 
 * @author dipa
 *
 */
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

	private SegmentNode root;

	public RangeSumQueryMutable(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);
    }

	public void update(int i, int val) {
		update(i, val, this.root);
	}

	public int sumRange(int i, int j) {
		return sumRangeHelper(i, j, root);
	}

	private SegmentNode buildTree(int[] nums, int left, int right) {
		if (left < 0 || right >= nums.length || left > right) {
			return null;
		}

		if (left == right) {
			return new SegmentNode(left, right, nums[left]);
		}

		int middle = left + (right - left) / 2;
		SegmentNode leftTree = buildTree(nums, left, middle);
		SegmentNode rightTree = buildTree(nums, middle + 1, right);
		int sum = (leftTree == null ? 0 : leftTree.sum) + (rightTree == null ? 0 : rightTree.sum);
		SegmentNode ret = new SegmentNode(left, right, sum);
		ret.left = leftTree;
		ret.right = rightTree;
		return ret;
	}

	private int update(int i, int v, SegmentNode root) {
		if (root == null || i < root.start || i > root.end) {
			return root == null ? 0 : root.sum;
		} else if (root.start == root.end && i == root.start) {
			root.sum = v;
			return v;
		} else {
			root.sum = update(i, v, root.left) + update(i, v, root.right);
			return root.sum;
		}
	}

	private int sumRangeHelper(int i, int j, SegmentNode node) {
		if (node == null || j < node.start || i > node.end) {
			return 0;
		}

		if (node.start >= i && node.end <= j) {
			return node.sum;
		} else {
			return sumRangeHelper(i, j, node.left) + sumRangeHelper(i, j, node.right);
		}
	}

	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.update(1, 10);
	// numArray.sumRange(1, 2);
}

package Common;

public class BSTWithRank {
	
	private static class AugmentNode {
		
		private int rank;
		private int val;
		private AugmentNode left;
		private AugmentNode right;
		
		public AugmentNode(int v) {
			this.val = v;
			this.rank = 0;
		}
	}
	
	private AugmentNode root;
	private int size;
	
	public BSTWithRank() {
		
	}
	
	public void add(int val) {
		this.root = add(root, val);
	}
	
	private AugmentNode add(AugmentNode root, int v) {
		this.size++;
		if (root == null) {
			return new AugmentNode(v);
		} else if (root.val >= v) {
			root.rank++;
			root.left = add(root.left, v);
		} else {
			root.right = add(root.right, v);
		}
		return root;
	}
	
	public int getValueOfRank(int n) {
		if (n <= size) {
			return getValueOfRank(this.root, n);
		} else {
			throw new IllegalArgumentException("The number of elements is smaller than given rank.");
		}
	}
	
	private int getValueOfRank(AugmentNode root, int n) {
		if (root.rank + 1 == n) {
			return root.val;
		} else if (root.rank > n) {
			return getValueOfRank(root.left, n);
		} else {
			return getValueOfRank(root.right, n - (root.rank + 1));
		}
	}
}

package Leetcode;

import Common.TreeNode;

public class ClosestValueInBST {
	
	public int closestValue(TreeNode root, double target) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		
		int closest = root.val;
		TreeNode n = root;
		while (n != null) {
			if (Math.abs(closest - target) > Math.abs(n.val - target)) {
				closest = n.val;
			}
			n = target < n.val ? n.left : n.right; 
		}
		return closest;
	}
}

package MiscQuestions;

import Common.TreeNode;

public class FindClosestNodeBST {
	
	/*
	 * Iterative solution
	 */
	public TreeNode findClosestNode(TreeNode root, int key) {
		TreeNode p = root;
		int diff = Integer.MAX_VALUE;
		TreeNode ret = null;
		while (p != null) {
			int d = key - p.val;
			if (d == 0) {
				return p;
			} 
			
			if (diff > Math.abs(d)) {
				ret = p;
				diff = Math.abs(d);
			}
			
			if (d < 0) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return ret;
	}
	
	public TreeNode findClosestNodeRec(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		
		TreeNode minChild = null;
		if (key == root.val) {
			return root;
		} else if (key > root.val) {
			minChild = findClosestNodeRec(root.right, key);
		} else {
			minChild = findClosestNodeRec(root.left, key);
		}
		
		if (minChild != null && Math.abs(minChild.val - key) < Math.abs(root.val - key)) {
			return minChild;
		} else {
			return root;
		}
		
	}
}

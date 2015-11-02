package MiscQuestions;

import Common.TreeNode;

public class DeepestLeftNode {
	
	private static class Result {
		int maxLevel;
		TreeNode ret;
	}
	
	/**
	 * Recursively go through all nodes and update the
	 * deepest left node.
	 * @param root
	 * @return
	 */
	public static TreeNode findDeepestLeftNode(TreeNode root) {
		Result r = new Result();
		helper(root, r, 0, false);
		return r.ret;
	}
	
	private static void helper(TreeNode root, Result r, int lvl, boolean isLeft) {
		if (root == null) {
			return;
		}
		
		if (isLeft && root.left == null && root.right == null && lvl > r.maxLevel) {
			r.maxLevel = lvl;
			r.ret = root;
			return;
		}
		
		helper(root.left, r, lvl + 1, true);
		helper(root.right, r, lvl + 1, false);
	}
	
	public static void main(String[] args) {
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.right.left = new TreeNode(5);
	    root.right.right = new TreeNode(6);
	    root.right.left.right = new TreeNode(7);
	    root.right.right.right = new TreeNode(8);
	    root.right.left.right.left = new TreeNode(9);
	    root.right.right.right.right = new TreeNode(10);
	    
	    TreeNode node = findDeepestLeftNode(root);
	    System.out.println(node.val);
	}
}

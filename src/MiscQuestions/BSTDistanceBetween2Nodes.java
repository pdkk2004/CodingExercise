package MiscQuestions;

import Common.TreeNode;

/**
 * http://www.fgdsb.com/2015/01/08/distance-in-binary-tree/
 * @author kkdpan
 *
 */
public class BSTDistanceBetween2Nodes {

	private static int depth1 = -1;
	private static int depth2 = -1;
	private static int ret = -1;
	
	public static int distance(TreeNode root, TreeNode t1, TreeNode t2) {
		TreeNode lca = findLCA(root, t1, t2, 0);
		if (depth1 >= 0 && depth2 >= 0) {
			return ret;
		} else if (depth1 >= 0) {
			return depth(lca, t2);
		} else if (depth2 >= 0){
			return depth(lca, t1);
		} else {
			return -1;
		}
	}
	
	private static TreeNode findLCA(TreeNode root, TreeNode t1, TreeNode t2, int cur) {
		if (root == null) {
			return null;
		}
		
		if (root == t1) {
			depth1 = cur;
			return root;
		} else if (root == t2) {
			depth2 = cur;
			return root;
		}
		
		TreeNode L = findLCA(root.left, t1, t2, cur + 1);
		TreeNode R = findLCA(root.right, t1, t2, cur + 1);
		if (L != null && R != null) {
			ret = depth1 + depth2 - 2 * cur;
			return root;
		} else {
			return L == null ? R : L;
		}
	}
	
	private static int depth(TreeNode root, TreeNode target) {
		if (root == null || target == null) {
			throw new IllegalArgumentException();
		}
		return depthHelper(root, target, 0);
	}
	
	private static int depthHelper(TreeNode root, TreeNode target, int depth) {
		if (root == null) {
			return 0;
		}
		
		if (root == target) {
			return depth;
		}
		
		return Math.max(depthHelper(root.left, target, depth + 1), depthHelper(root.right, target, depth + 1));
	}
}

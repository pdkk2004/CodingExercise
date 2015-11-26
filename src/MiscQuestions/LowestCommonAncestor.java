package MiscQuestions;

import Common.TreeNode;
import Common.TreeNodeWithParent;

public class LowestCommonAncestor {
	
	/**
	 * Find Lowest common Ancestor without parent pointer available.
	 * @param root
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode t1, TreeNode t2) {
		if (root == null) {
			return null;
		}
		
		if (root == t1 || root == t2) {
			return root;
		}
		
		TreeNode L = lowestCommonAncestor(root.left, t1, t2);
		TreeNode R = lowestCommonAncestor(root.right, t1, t2);
		if (L != null && R != null) {
			return root;
		} else {
			return L == null ? R : L;
		}
	}
	
	public static TreeNodeWithParent lowestCommonAncestor(TreeNodeWithParent root, TreeNodeWithParent t1, TreeNodeWithParent t2) {
		int depth1 = depth(t1);
		int depth2 = depth(t2);
		int diff = Math.abs(depth1 - depth2);
		if (depth1 > depth2) {
			TreeNodeWithParent temp = t1;
			t1 = t2;
			t2 = temp;
		}
		for (int i = 0; i < diff; i++) {
			t2 = t2.p;
		}
		while (t2 != null && t1 != null) {
			if (t2 == t1) {
				return t2;
			}
			t2 = t2.p;
			t1 = t1.p;
		}
		return null;
	}
	
	private static int depth(TreeNodeWithParent node) {
		int d = 0;
		TreeNodeWithParent n = node;
		while (n != null) {
			d++;
			n = n.p;
		}
		return d;
	}
}

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
		TreeNodeWithParent lowerNode = depth1 > depth2 ? t1 : t2;
		TreeNodeWithParent higherNode = depth1 > depth2 ? t2 : t1;
		for (int i = 0; i < diff; i++) {
			lowerNode = lowerNode.p;
		}
		while (lowerNode != null && higherNode != null) {
			if (lowerNode == higherNode) {
				return lowerNode;
			}
			lowerNode = lowerNode.p;
			higherNode = higherNode.p;
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

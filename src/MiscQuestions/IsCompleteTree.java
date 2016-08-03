package MiscQuestions;

import java.util.LinkedList;
import java.util.Queue;

import Common.TreeNode;

/**
 * http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
 * @author dipa
 *
 */
public class IsCompleteTree {
	
	public boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}
		
		Queue<TreeNode> curQ = new LinkedList<>();
		
		curQ.offer(root);
		boolean isFullNode = true;
		while (!curQ.isEmpty()) {
			TreeNode n = curQ.poll();
			if (!isFullNode) {
				if (n.left != null || n.right != null) {
					return false;
				}
			} else {
				if (n.left == null || n.right == null) {
					isFullNode = false;
				}
				if (n.left == null && n.right != null) {
					return false;
				}
				if (n.left != null) {
					curQ.offer(n.left);
				}
				if (n.right != null) {
					curQ.offer(n.right);
				}
			}
		}
		return true;
	}
}

package MiscQuestions;

import java.util.Stack;

import Common.TreeNode;

/**
 * http://www.fgdsb.com/2015/01/03/subtree/
 * @author kkdpan
 *
 */
public class Subtree {
	
	public static boolean isSubtree(TreeNode t1, TreeNode t2) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(t1);
		while (!stack.isEmpty()) {
			TreeNode n = stack.pop();
			if (n.val == t2.val && isSameTree(n, t2)) {
				return true;
			}
			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
		return false;
	}
	
	private static boolean isSameTree(TreeNode t1, TreeNode t2) {
		if (t1 == null || t2 == null) {
			return t1 == t2;
		}
		if (t1.val != t2.val) {
			return false;
		} else {
			return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
		}
	}
}

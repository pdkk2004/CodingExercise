package MiscQuestions;

import java.util.Stack;

import Common.TreeNode;

/**
 * http://www.fgdsb.com/2015/01/03/two-sum-in-bst/
 * @author dipa
 */
public class TwoSumInBST {
	
	public static TreeNode[] twoSumInBST(TreeNode root, int sum) {
		TreeNode[] ret = new TreeNode[2];
		if (root == null) {
			return ret;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode n = stack.pop();
			TreeNode other = findValue(sum - n.val, root, n);
			if (other != null) {
				ret[0] = n;
				ret[1] = other;
				break;
			}
			
			if (n.right != null) {
				stack.push(n.right);
			}
			if (n.left != null) {
				stack.push(n.left);
			}
		}
		return ret;
	}
	
	private static TreeNode findValue(int target, TreeNode root, TreeNode origin) {
		TreeNode p = root;
		while (p != null) {
			if (p.val == target && p != origin) {
				return p;
			} else if (p.val > target) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return null;
	}
}

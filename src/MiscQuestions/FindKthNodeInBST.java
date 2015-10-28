package MiscQuestions;

import java.util.Stack;

import Common.TreeNode;

public class FindKthNodeInBST {
	
	public static TreeNode findKthNode(TreeNode root, int k) {
		int count = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode n = stack.pop();
				count++;
				if (count == k) {
					return n;
				}
				n = n.right;
			}
		}
		return null;
	}
}

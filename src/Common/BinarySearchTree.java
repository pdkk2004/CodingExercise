package Common;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {
	
	private TreeNode root;
	
	public BinarySearchTree() {
		
	}
	
	public BinarySearchTree(TreeNode root) {
		this.root = root;
	}
	
	public void add(int val) {
		TreeNode p = this.root;
		if (p == null) {
			this.root = new TreeNode(val);
			return;
		}
		
		while (p != null) {
			if (val <= p.val) {
				if (p.left == null) {
					p.left = new TreeNode(val);
					break;
				} else {
					p = p.left;
				}
			} else {
				if (p.right == null) {
					p.right = new TreeNode(val);
					break;
				} else {
					p = p.right;
				}
			}
		}
	}
	
	public boolean conatins(int val) {
		TreeNode p = root;
		while (p != null) {
			if (p.val == val) {
				return true;
			} else if (val < p.val) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return false;
	}
	
	public static List<Integer> PreTraverse(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				ret.add(p.val);
				p = p.left;
			} else {
				TreeNode temp = stack.pop();
				ret.add(temp.val);
				p = temp.right;
			}
		}
		return ret;
	}
	
	public static List<Integer> PostTraverse(TreeNode root) {
		List<Integer> ret = new LinkedList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return ret;
		}
		
		TreeNode pre = null;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			if (pre == null || pre.left == node || pre.right == node) {
				if (node.left != null) {
					stack.push(node.left);
				} else if (node.right != null) {
					stack.push(node.right);
				}
				pre = node;
			} else if (node.left == pre && node.right != null) {
				stack.push(node.right);
				pre = node;
			} else {
				TreeNode n = stack.pop();
				ret.add(n.val);
				pre = n;
			}
		}
		return ret;
	}
}

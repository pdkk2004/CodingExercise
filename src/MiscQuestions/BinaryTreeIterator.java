package MiscQuestions;

import java.util.Iterator;
import java.util.Stack;

public class BinaryTreeIterator {

	private class TreeNode {
		TreeNode left;
		TreeNode right;
		int v;

		public TreeNode(int v) {
			this.v = v;
		}
	}

	public void preOrderTraverse(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;

		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode toPrt = stack.pop();
				System.out.print(toPrt.v);
				p = toPrt.right;
			}
		}
	}

	public Iterator<TreeNode> inOrderIterator(TreeNode root) {
		return new InOrderIterator(root);
	}
	
	public Iterator<TreeNode> preOrderIterator(TreeNode root) {
		return new PreOrderIterator(root);
	}

	private class InOrderIterator implements Iterator<TreeNode> {

		private Stack<TreeNode> stack;

		private TreeNode p;

		public InOrderIterator(TreeNode root) {
			this.stack = new Stack<TreeNode>();
			this.p = root;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public TreeNode next() {
			TreeNode ret = stack.pop();
			p = ret.right;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			return ret;
		}

		public void remove() {

		}
	}
	
	private class PreOrderIterator implements Iterator<TreeNode> {
		
		private Stack<TreeNode> stack;
		
		public PreOrderIterator(TreeNode root) {
			stack = new Stack<TreeNode>();
			if (root != null) {
				stack.push(root);
			}
		}
		
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		
		public TreeNode next() {
			TreeNode ret = stack.pop();
			if (ret.right != null) {
				stack.push(ret.right);
			}
			if (ret.left != null) {
				stack.push(ret.left);
			}
			return ret;
		}
		
		public void remove() {
			
		}
	}
}

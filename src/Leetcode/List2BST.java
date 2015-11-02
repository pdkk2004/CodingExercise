package Leetcode;

import Common.ListNode;
import Common.TreeNode;

public class List2BST {
	
	private static class Pointer {
		private ListNode node;
		public Pointer(ListNode node) {
			this.node = node;
		}
	}
	
	public static TreeNode List2BST(ListNode head) {
		ListNode p = head;
		int l = 0;
		while (p != null) {
			l++;
			p = p.next;
		}
		
		return helper(new Pointer(head), 0, l - 1);
	}
	
	private static TreeNode helper(Pointer p, int b, int e) {
		if (p == null || b > e) {
			return null;
		}

		int m = b + (e - b) / 2;
		TreeNode left = helper(p, 0, m - 1);
		TreeNode ret = new TreeNode(p.node.val);
		p.node = p.node.next;
		TreeNode right = helper(p, m + 1, e);
		ret.left = left;
		ret.right = right;
		return ret;
	}
}

package MiscQuestions;

import java.util.Stack;

import org.junit.Test;

import Common.TreeNode;
import org.junit.*;

/**
 * //http://www.fgdsb.com/2015/01/18/merge-BST/
 * @author dipa
 *
 */
public class MergeTwoBST {

	private static class TreeNodeWrapper {
		private TreeNode node;
		
		private TreeNodeWrapper(TreeNode n) {
			this.node = n;
		}
	}
	
	public static TreeNode mergeTwoBST(TreeNode root1, TreeNode root2) {
		TreeNode t1 = flattenBST(root1);
		TreeNode t2 = flattenBST(root2);
		TreeNode t = mergeList(t1, t2);
		
		int c = 0;
		TreeNode p = t;
		while (p != null) {
			c++;
			p = p.right;
		}
		return convertList2BST(new TreeNodeWrapper(t), 0, c - 1);
	}
	
	/**
	 * Merge two sorted linked list to a new sorted list.
	 * @param t1
	 * @param t2
	 * @return
	 */
	private static TreeNode mergeList(TreeNode t1, TreeNode t2) {
		TreeNode head = new TreeNode(-1);
		TreeNode end = head;
		while (t1 != null && t2 != null) {
			if (t1.val <= t2.val) {
				end.right = t1;
				t1 = t1.right;
			} else {
				end.right = t2;
				t2 = t2.right;
			}
			end = end.right;
		}
		
		if (t1 != null) {
			end.right = t1;
		} else {
			end.right = t2;
		}
		return head.right;
	}
	
	/**
	 * Convert a sorted single linked list to a balanced BST.
	 * @param head
	 * @param start
	 * @param end
	 * @return
	 */
	private static TreeNode convertList2BST(TreeNodeWrapper head, int start, int end) {
		if (head == null || start < 0 || start > end) {
			return null;
		}
		int m = (start + end) / 2;
		TreeNode left = convertList2BST(head, start, m - 1);
		TreeNode root = head.node;
		root.left = left;
		head.node = root.right;
		root.right = convertList2BST(head, m + 1, end);
		return root;
	}
	
	/**
	 * Conver a BST to a single linkedlist based on in-order traverse.
	 * @param root
	 * @return
	 */
	private static TreeNode flattenBST(TreeNode root) {
		TreeNode head = null;
		TreeNode pointer = head;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while (p != null || !stack.isEmpty()) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				TreeNode toPop = stack.pop();
				if (head == null) {
					head = toPop;
					pointer = head;
				} else {
					pointer.right = toPop;
					toPop.left = null;
					pointer = toPop;
				}
				p = toPop.right;
			}
		}
		return head;
	}
	
	/**
	 * Convert a BST to a single linkedlist recursively based on in-order traverse.
	 * @param root
	 * @return
	 */
	private static TreeNode flattenBSTRec(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode leftHead = flattenBSTRec(root.left);
		TreeNode rightHead = flattenBSTRec(root.right);
		
		TreeNode leftTail = leftHead;
		while (leftTail != null && leftTail.right != null) {
			leftTail = leftTail.right;
		}
		
		if (leftTail != null) {
			leftTail.right = root;
		}
		root.left = null;
		root.right = rightHead;
		return leftHead == null ? root : leftHead;
	}
	
	@Test
	public void testFlattenBST() {
		String t2 = print(flattenBST(createTestBST()));
		System.out.println(t2);
		
		Assert.assertTrue("3 4 5 6 7 8 10 ".equals(t2));
	}
	
	@Test
	public void testFlattenBSTRec() {
		String t2 = print(flattenBSTRec(createTestBST()));
		System.out.println(t2);
		
		Assert.assertTrue("3 4 5 6 7 8 10 ".equals(t2));
	}
	
	private String print(TreeNode head) {
		StringBuilder sb = new StringBuilder();
		while (head != null) {
			sb.append(head.val).append(" ");
			head = head.right;
		}
		return sb.toString();
	}
	
	private TreeNode createTestBST() {
		TreeNode n7 = new TreeNode(7);
		TreeNode n4 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		TreeNode n6 = new TreeNode(6);
		TreeNode n5 = new TreeNode(5);
		TreeNode n10 = new TreeNode(10);
		TreeNode n8 = new TreeNode(8);
		n7.left = n4;
		n4.left = n3;
		n4.right = n6;
		n6.left = n5;
		n7.right = n10;
		n10.left = n8;
		
		return n7;
	}
}

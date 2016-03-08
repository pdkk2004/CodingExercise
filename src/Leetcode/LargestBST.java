package Leetcode;

import org.junit.Test;

import Common.TreeNode;
import org.junit.*;

/**
 * Leetcode: Find largest BST subtree.
 * Solution & Discussion: http://articles.leetcode.com/largest-binary-search-tree-bst-in/
 * @author dipa
 *
 */
public class LargestBST {
	
	private static TreeNode largestBSTRoot;
	
	private static int minValue;
	
	private static int maxValue;
	
	private static int nodeCount;
	
	public TreeNode findLargestBST(TreeNode root) {
		helper(root);
		return largestBSTRoot;
	}
	
	private int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		boolean isBST = true;
		int left = helper(node.left);
		int currMin = left == 0 ? node.val : minValue;
		if (left == -1 || left != 0 && node.val <= maxValue) {
			isBST = false;
		}
		
		int right = helper(node.right);
		int currMax = right == 0 ? node.val : maxValue;
		if (right == -1 || right != 0 && node.val >= minValue) {
			isBST = false;
		}
		
		if (isBST) {
			minValue = currMin;
			maxValue = currMax;
			int totalNodes = 1 + left + right;
			if (totalNodes > nodeCount) {
				nodeCount = totalNodes;
				largestBSTRoot = node;
			}
			return totalNodes;
		} else {
			return -1;
		}
	}
	
	@Test
	public void test() {
		LargestBST lBST = new LargestBST();
		TreeNode root = createBST();
		TreeNode subtreeRoot = lBST.findLargestBST(root);
		Assert.assertEquals(5, subtreeRoot.val);
		Assert.assertEquals(1, subtreeRoot.left.val);
		Assert.assertEquals(8, subtreeRoot.right.val);
		Assert.assertNull(subtreeRoot.left.left);
		Assert.assertNull(subtreeRoot.left.right);
		Assert.assertNull(subtreeRoot.right.left);
		Assert.assertNull(subtreeRoot.right.right);
	}
	
	private TreeNode createBST() {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(8);
		root.right = new TreeNode(15);
		root.right.right = new TreeNode(7);
		return root;
	}
}

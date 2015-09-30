package Leetcode;

import Common.TreeNode;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BalancedBinaryTree {
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

}

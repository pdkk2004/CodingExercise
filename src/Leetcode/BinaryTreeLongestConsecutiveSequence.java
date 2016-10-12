package Leetcode;

import Common.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
    
    private int longest = 0;
    
    public int longestConsecutive(TreeNode root) {
        helper(root);
        
        return longest;
    }
    
    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int L = helper(root.left);
        int R = helper(root.right);
        int ret = 1;
        if (root.left != null && root.left.val - 1 == root.val) {
            ret = L + 1;
        }
        if (root.right != null && root.right.val - 1 == root.val) {
            ret = Math.max(ret, R + 1);
        }
        
        longest = Math.max(longest, ret);
        return ret;
    }
}

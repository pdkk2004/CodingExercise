package Leetcode;

import Common.TreeNode;

public class CountUnivalueSubtrees {
    
    private int count;
    
    public int countUnivalSubtrees(TreeNode root) {
        isUnival(root);
        return count;
    }
    
    private boolean isUnival(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        
        boolean R = isUnival(root.right);
        boolean L = isUnival(root.left);
        if (R && L && (root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val)){
            count++;
            return true;
        } else {
            return false;
        }
    }
}

package Leetcode;

import Common.TreeNode;

public class HouseRobber3 {
	
	// Recursive version
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(robInclude(root), robExclude(root));
    }
    
    private int robInclude(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return robExclude(root.left) + robExclude(root.right) + root.val;
    }
    
    private int robExclude(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return rob(root.left) + rob(root.right);
    }
}

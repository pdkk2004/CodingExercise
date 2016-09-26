package Leetcode;

import java.util.Stack;

import Common.TreeNode;

public class LargestBSTSubtree {
	
    private int max = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        int c = 0;
        if ((c = isBST(root)) >= 0) {
            return c;
        } else {
            return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
        }
    }
    
    private int isBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        int count = 0;
        
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode n = stack.pop();
                count++;
                if (pre != null && n.val < pre.val) {
                    return -1;
                }
                pre = n;
                p = n.right;
            }
        }
        return count;
    }
}

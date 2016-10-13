package Leetcode;

import Common.TreeNode;

public class ClosestBinarySearchTreeValue {
	
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return closest;
    }
}

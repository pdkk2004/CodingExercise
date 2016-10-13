package Leetcode;

import Common.TreeNode;

public class InorderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ret = null;
        TreeNode n = root;
        while (n != null) {
            if (n.val > p.val) {
                ret = n;
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return ret;
    }
}

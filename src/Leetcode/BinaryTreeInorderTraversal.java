package Leetcode;

import java.util.ArrayList;
import java.util.Stack;

import Common.TreeNode;

public class BinaryTreeInorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode n = root;
        while (n != null || !stack.isEmpty()) {
            if (n != null) {
                stack.push(n);
                n = n.left;
            } else {
                TreeNode node = stack.pop();
                ret.add(node.val);
                n = node.right;
            }
        }
        return ret;
    }
}

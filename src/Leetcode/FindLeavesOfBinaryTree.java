package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Common.TreeNode;

public class FindLeavesOfBinaryTree {

    
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        helper(root, ret);
        return ret;
    }
    
    private int helper(TreeNode root, List<List<Integer>> ret) {
        if (root == null) {
            return 0;
        }

        int depth = Math.max(helper(root.left, ret), helper(root.right, ret)) + 1;
        if (depth > ret.size()) {
            ret.add(new LinkedList<>());
        }
        ret.get(depth - 1).add(root.val);
        return depth;
    }
}

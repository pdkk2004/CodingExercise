package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Common.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return ret;
        }
        
        Queue<TreeNode> curQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> nextQueue = new LinkedList<TreeNode>();
        ArrayList<Integer> r = new ArrayList<Integer>();
        
        curQueue.add(root);
        
        while (!curQueue.isEmpty()) {
            TreeNode n = curQueue.poll();
            r.add(n.val);
            if (n.left != null) {
                nextQueue.offer(n.left);
            }
            if (n.right != null) {
                nextQueue.offer(n.right);
            }
            if (curQueue.isEmpty()) {
                ret.add(r);
                r = new ArrayList<Integer>();
                Queue<TreeNode> temp = curQueue;
                curQueue = nextQueue;
                nextQueue = temp;
            }
        }
        return ret;
    }
}

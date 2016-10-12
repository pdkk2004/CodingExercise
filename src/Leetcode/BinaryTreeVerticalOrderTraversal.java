package Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Common.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
    private int mostLeft = 0;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        nodeQ.offer(root);
        colQ.offer(0);
        int leftMost = 0;
        
        while (!nodeQ.isEmpty()) {
            TreeNode node = nodeQ.poll();
            int col = colQ.poll();
            if (col < leftMost) {
                leftMost = col;
                ret.add(0, new LinkedList<>());
            }
            if (col - leftMost >= ret.size()) {
                ret.add(new LinkedList<>());
            }
            ret.get(col - leftMost).add(node.val);
            
            if (node.left != null) {
                nodeQ.offer(node.left);
                colQ.offer(col - 1);
            }
            
            if (node.right != null) {
                nodeQ.offer(node.right);
                colQ.offer(col + 1);
            }
        }
        return ret;
    }
    
    private void helper(TreeNode root, int vIndex, ArrayList<List<Integer>> ret) {
        if (root == null) {
            return;
        }
        if (vIndex < mostLeft) {
            ret.add(0, new LinkedList<Integer>());
            mostLeft = vIndex;
        } else if (vIndex - mostLeft >= ret.size()) {
            ret.add(new LinkedList<Integer>());
        }
        
        ret.get(vIndex - mostLeft).add(root.val);
        helper(root.left, vIndex - 1, ret);
        helper(root.right, vIndex + 1, ret);
    }
}

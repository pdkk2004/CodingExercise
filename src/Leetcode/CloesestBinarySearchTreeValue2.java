package Leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import Common.TreeNode;

public class CloesestBinarySearchTreeValue2 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ret = new LinkedList<>();
        Stack<TreeNode> preStack = new Stack<>();
        Stack<TreeNode> postStack = new Stack<>();
        populatePreStack(root, target, preStack);
        populatePostStack(root, target, postStack);
        
        if (!preStack.isEmpty() && !postStack.isEmpty() && preStack.peek() == postStack.peek()) {
            getPreNext(preStack);
        }
        
        while (k-- > 0) {
            if (!preStack.isEmpty() && !postStack.isEmpty()) {
                if (Math.abs(preStack.peek().val - target) <= Math.abs(postStack.peek().val - target)) {
                    ret.add(preStack.peek().val);
                    getPreNext(preStack);
                } else {
                    ret.add(postStack.peek().val);
                    getPostNext(postStack);
                }
            } else if (!preStack.isEmpty()) {
                ret.add(preStack.peek().val);
                getPreNext(preStack);
            } else if (!postStack.isEmpty()) {
                ret.add(postStack.peek().val);
                getPostNext(postStack);
            }
        }
        return ret;
    }
    
    private void populatePreStack(TreeNode root, double target, Stack<TreeNode> stk) {
        TreeNode p = root;
        while (p != null) {
            if (target == p.val) {
                stk.push(p);
                break;
            }
            if (p.val < target) {
                stk.push(p);
                p = p.right;
            } else {
                p = p.left;
            }
        }
    }
    
    private void populatePostStack(TreeNode root, double target, Stack<TreeNode> stk) {
        TreeNode p = root;
        while (p != null) {
            if (target == p.val) {
                stk.push(p);
                break;
            }
            if (p.val > target) {
                stk.push(p);
                p = p.left;
            } else {
                p = p.right;
            }
        }
    }
    
    private int getPreNext(Stack<TreeNode> stack) {
        TreeNode pop = stack.pop();
        int ret = pop.val;
        TreeNode p = pop.left;
        while (p != null) {
            stack.push(p);
            p = p.right;
        }
        return ret;
    }
    
    private int getPostNext(Stack<TreeNode> stack) {
        TreeNode pop = stack.pop();
        int ret = pop.val;
        TreeNode p = pop.right;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        return ret;
    }
	
}

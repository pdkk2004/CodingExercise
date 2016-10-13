package Leetcode;

import java.util.Stack;

public class VerifyPreorderSequenceInBST {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < low) {
                return false;
            }
            while (!stack.isEmpty() && preorder[i] > stack.peek()) {
                low = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }
}

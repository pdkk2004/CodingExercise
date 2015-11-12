package MiscQuestions;

import Common.TreeNode;

/**
 * http://www.fgdsb.com/2015/01/03/get-next-node-of-bst/
 * @author dipa
 *
 */
public class GetNextNodeOfBST {
	
	public static TreeNode getNextNode(TreeNode root, int val) {
		TreeNode cur = root, ret = null;
		while (cur != null) {
			if (cur.val >= val) {
				ret = cur;
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		return ret;
	}
}

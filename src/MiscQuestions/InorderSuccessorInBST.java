package MiscQuestions;

import Common.TreeNode;

public class InorderSuccessorInBST {
	
	private static class TreeNodeExtend {
		
		public TreeNodeExtend p;
		
		public TreeNodeExtend left;
		
		public TreeNodeExtend right;
		
		public int v;
		
		public TreeNodeExtend(int v) {
			this.v = v;
		}
	}
	
	public static TreeNodeExtend findInorderSuccessor(TreeNodeExtend root) {
		if (root == null) {
			return null;
		}
		
		if (root.right != null) {
			TreeNodeExtend r = root.right;
			while (r.left != null) {
				r = r.left;
			}
			return r;
		}
		
		TreeNodeExtend parent = root.p;
		while (parent != null && parent.right == root) {
			root = parent;
			parent = parent.p;
		}
		return parent;
	}
}

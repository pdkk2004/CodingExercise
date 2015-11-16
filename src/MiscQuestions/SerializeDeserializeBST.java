package MiscQuestions;

import Common.TreeNode;

/**
 * http://www.fgdsb.com/2015/01/03/serialization-and-deserialization-of-a-binary-tree/
 * @author dipa
 *
 */
public class SerializeDeserializeBST {
	
	public static String serializeBST(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();
	}
	
	private static void serializeHelper(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append('#');
			return;
		}
		
		sb.append(root.val + " ");
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);
	}
	
	public static TreeNode deserializeBST(String str, char token) {
		if (str == null || str.length() == 0) {
			return null;
		}
		
		String[] tokens = str.split("\\s+");
		return deserialize(tokens, new Pointer());
	}
	
	private static class Pointer {
		private int p;
		
		public Pointer() {
			this.p = 0;
		}
		
		public Pointer(int p) {
			this.p = p;
		}
		
		public int getPointer() {
			return p;
		}
		
		public int getAndAdvance() {
			int ret = this.p;
			advance();
			return ret;
		}
		
		public int advance() {
			return ++this.p;
		}
	}
	
	private static TreeNode deserialize(String[] tokens, Pointer start) {
		if (start.getPointer() > tokens.length) {
			return null;
		}
		if (tokens[start.getPointer()] == "#") {
			start.advance();
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(tokens[start.getPointer()]));
		start.advance();
		root.left = deserialize(tokens, start);
		root.right = deserialize(tokens, start);
		return root;
	}
}

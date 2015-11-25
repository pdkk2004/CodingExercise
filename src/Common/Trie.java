package Common;

public class Trie {
	
	private TrieNode root;
	private int size;
	
	public static class TrieNode {
		private boolean isEnd;
		private TrieNode[] children;
		private int count;
		
		public TrieNode() {
			this.isEnd = false;
			this.children = new TrieNode[256];
			this.count = 0;
		}
		
		/**
		 * Return whether the node is an end of a word.
		 * @return
		 */
		public boolean isEnd() {
			return this.isEnd;
		}
		
		/**
		 * Return the children nodes of this node.
		 * @return
		 */
		public TrieNode[] getChildren() {
			return this.children;
		}

		public int getCount() {
			return count;
		}
	}
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	/**
	 * Add a new word into trie
	 * @param str. The word want to add.
	 */
	public void add(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Input string to add is null.");
		}
		TrieNode n = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (n.children[c] == null) {
				n.children[c] = new TrieNode();
			}
			n = n.children[c];
			n.count++;
		}
		n.isEnd = true;
		size++;
	}
	
	/**
	 * Check whether the trie has a word.
	 * @param str. The word to check existence.
	 * @return
	 */
	public boolean has(String str) {
		if (str == null) {
			throw new IllegalArgumentException("Input string to add is null.");
		}
		TrieNode p = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (p.children[c] == null) {
				return false;
			} else {
				p = p.children[c];
			}
		}
		return p.isEnd;
	}
	
	/**
	 * Get size of the trie.
	 * @return
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Return the 
	 * @return
	 */
	public TrieNode getRoot() {
		return this.root;
	}
}

package Leetcode;
class WordDictionary {

	public static void main(String[] args) {
		WordDictionary dic = new WordDictionary();
		dic.addWord("a");
		dic.addWord("a");
//		System.out.println(dic.search("."));
//		System.out.println(dic.search("a"));
//		System.out.println(dic.search("aa"));
//		System.out.println(dic.search("a"));
		System.out.println(dic.search(".a"));
//		System.out.println(dic.search("a."));
	}

	private static class Node {
		Node[] children;
		boolean isEnd;

		public Node() {
			this.children = new Node[26];
			this.isEnd = false;
		}
	}

	private Node root = new Node();

	// Adds a word into the data structure.
	public void addWord(String word) {
		Node p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (p.children[c - 'a'] == null) {
				p.children[c - 'a'] = new Node();
			}
			p = p.children[c - 'a'];
		}
		p.isEnd = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		Node p = root;
		return search(word, p);
	}

	private boolean search(String word, Node root) {
		if ("".equals(word)) {
			return root != null && root.isEnd;
		}

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c != '.' && root.children[c - 'a'] != null) {
				root = root.children[c - 'a'];
			} else if (c != '.') {
				return false;
			} else {
				for (Node n : root.children) {
					if (search(word.substring(i + 1), n)) {
						return true;
					}
				}
				return false;
			}
		}
		return root != null && root.isEnd;
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
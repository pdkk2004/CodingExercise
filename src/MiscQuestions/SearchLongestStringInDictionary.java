package MiscQuestions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

import Common.Trie;
import Common.Trie.TrieNode;
import org.junit.*;

/**
 * http://www.fgdsb.com/2015/01/07/search-longest-string-in-dict/
 * 
 * @author dipa
 *
 */
public class SearchLongestStringInDictionary {

	/**
	 * Use BFS to find the length of longest string
	 * 
	 * @param input
	 * @param dict
	 * @return
	 */
	public static int searchLongestStringBFS(String input, Set<String> dict) {
		Trie trie = new Trie();
		for (String s : dict) {
			trie.add(s);
		}

		Set<Character> charSet = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			charSet.add(input.charAt(i));
		}

		int maxLength = 0;
		int len = 0;
		Queue<TrieNode> queue = new LinkedList<TrieNode>();
		Queue<TrieNode> nextQueue = new LinkedList<TrieNode>();
		queue.offer(trie.getRoot());
		while (!queue.isEmpty()) {
			TrieNode node = queue.poll();
			TrieNode[] children = node.getChildren();
			for (int i = 0; i < children.length; i++) {
				if (children[i] != null && charSet.contains((char) i)) {
					nextQueue.offer(children[i]);
					if (children[i].isEnd()) {
						maxLength = Math.max(maxLength, len + 1);
					}
				}
			}
			if (queue.isEmpty()) {
				len++;
				Queue<TrieNode> temp = queue;
				queue = nextQueue;
				nextQueue = temp;
			}
		}
		return maxLength;
	}

	/**
	 * Use DFS to find the longest string in Dictionary.
	 * 
	 * @param input
	 *            The input string pattern.
	 * @param dict
	 *            The dictionary of words.
	 * @return
	 */
	public static String searchLongestStringDFS(String input, Set<String> dict) {
		Trie trie = new Trie();
		for (String str : dict) {
			trie.add(str);
		}

		Set<Character> charSet = new HashSet<Character>();
		for (int i = 0; i < input.length(); i++) {
			charSet.add(input.charAt(i));
		}
		Result r = new Result("");
		dfs(charSet, trie.getRoot(), new StringBuilder(), r);
		return r.ret;
	}

	private static void dfs(Set<Character> charSet, TrieNode node, StringBuilder sb, Result r) {
		if (node == null) {
			return;
		}

		if (node.isEnd()) {
			String str = sb.toString();
			if (str.length() > r.ret.length()) {
				r.ret = str;
			}
		}

		TrieNode[] children = node.getChildren();
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null && charSet.contains((char) i)) {
				sb.append((char) i);
				dfs(charSet, children[i], sb, r);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	private static class Result {

		private String ret;

		public Result(String str) {
			this.ret = str;
		}
	}
	
	@Test
	public void test() {
		Set<String> dict = new HashSet<>();
		dict.add("abcde");
		dict.add("abc");
		dict.add("abbbc");
		dict.add("abbbccca");
		dict.add("abbbcccabbcx");
		
		String str = "abc";
		String r = searchLongestStringDFS(str, dict);
		System.out.println(r);
		int len = searchLongestStringBFS(str, dict);
		System.out.println(len);
		Assert.assertEquals(r.length(), len);
	}
}

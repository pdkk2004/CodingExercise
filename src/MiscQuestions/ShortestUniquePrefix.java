//package MiscQuestions;
//
//import java.util.LinkedList;
//import java.util.List;
//
//import org.junit.Test;
//
//import Common.Trie;
//import Common.Trie.TrieNode;
//
//public class ShortestUniquePrefix {
//
//	public static List<String> shortestUnquePrefix(String[] strs) {
//		Trie dict = new Trie();
//		for (String s : strs) {
//			dict.add(s);
//		}
//		
//		List<String> ret = new LinkedList<String>();
//		for (String s : strs) {
//			ret.add(s + ":" + findPrefix(dict, s));
//		}
//		return ret;
//	}
//	
//	public static String findPrefix(Trie dict, String str) {
//		TrieNode root = dict.getRoot();
//		int i = 0;
//		while (i < str.length()) {
//			char c = str.charAt(i);
//			if (root.getChildren()[c] != null && root.getChildren()[c].getCount() > 1) {
//				root = root.getChildren()[c];
//				i++;
//			} else {
//				return str.substring(0, i + 1);
//			}
//		}
//		return str;
//	}
//	
//	@Test
//	public void test() {
//		String[] input = {"zebra", "dog", "duck","dot"};
//		List<String> output = shortestUnquePrefix(input);
//		System.out.println(output.toString());
//		
//		String[] input1 = {"bearcat", "bear"};
//		List<String> output1 = shortestUnquePrefix(input1);
//		System.out.println(output1.toString());
//	}
//}

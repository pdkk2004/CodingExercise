package Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters {

	/**
	 * Solution
	 * from:http://bookshadow.com/weblog/2015/12/09/leetcode-remove-duplicate-
	 * letters/ O(n) time.
	 * @param s
	 * @return
	 */
	public static String removeDuplicateLetters(String s) {
		Map<Character, Integer> dic = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			dic.put(c, dic.getOrDefault(c, 0) + 1);
		}

		Stack<Character> stack = new Stack<>();
		Set<Character> visited = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			dic.put(c, dic.get(c) - 1);
			
			if (!visited.contains(c)) {
				while (!stack.isEmpty() && stack.peek() > c && dic.get(stack.peek()) > 0) {
					visited.remove(stack.pop());
				}
				stack.push(c);
				visited.add(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		Iterator<Character> iter = stack.iterator();
		while (iter.hasNext()) {
			sb.append(iter.next());
		}
		return sb.toString();
	}
}
